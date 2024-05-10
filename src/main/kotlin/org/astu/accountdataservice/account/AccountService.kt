package org.astu.accountdataservice.account

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.account.controller.AddAccountRequest
import org.astu.accountdataservice.account.controller.SummaryAccountDTO
import org.astu.accountdataservice.account.mapper.AccountMapper
import org.astu.accountdataservice.employee.EmployeeService
import org.astu.accountdataservice.student.StudentService
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val employeeService: EmployeeService,
    private val studentService: StudentService, private val accountMapper: AccountMapper
) {

    suspend fun addAccount(addAccountRequest: AddAccountRequest): UUID {
        val account = accountMapper.toEntity(addAccountRequest)
        withContext(Dispatchers.IO) {
            accountRepository.save(account)
        }

        addAccountRequest.employeeInfo?.let {
            runCatching {
                employeeService.addEmployee(account, it)
            }.onFailure {
                accountRepository.delete(account)
                throw it
            }
        }

        addAccountRequest.studentInfo?.let {
            runCatching {
                studentService.addStudent(account, it)
            }.onFailure {
                accountRepository.delete(account)
                throw it
            }
        }

        return account.id
    }

    fun getAccounts(): List<SummaryAccountDTO> = accountRepository.findAll().map(accountMapper::toSummaryDto)

    fun getAccount(id: UUID): AccountDTO =
        accountMapper.toDto(accountRepository.findById(id).orElseThrow { Exception() })
}