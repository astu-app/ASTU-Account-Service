package org.astu.accountdataservice.account

import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.account.controller.AddAccountRequest
import org.astu.accountdataservice.account.controller.SummaryAccountDTO
import org.astu.accountdataservice.account.mapper.AccountMapper
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.admin.AdminService
import org.astu.accountdataservice.employee.EmployeeService
import org.astu.accountdataservice.student.StudentService
import org.astu.accountdataservice.teacher.TeacherService
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val employeeService: EmployeeService,
    private val studentService: StudentService,
    private val teacherService: TeacherService,
    private val adminService: AdminService,
    private val accountMapper: AccountMapper
) {

    fun addAccount(addAccountRequest: AddAccountRequest): UUID {
        val account = Account(
            firstName = addAccountRequest.firstName,
            secondName = addAccountRequest.secondName,
            patronymic = addAccountRequest.patronymic
        )

        val createdAccount = accountRepository.save(account)
        addAccountRequest.employeeInfo?.let {
            runCatching {
                employeeService.addEmployee(createdAccount, it)
            }.onFailure {
                accountRepository.delete(createdAccount)
                throw it
            }
        }

        addAccountRequest.studentInfo?.let {
            runCatching {
                studentService.addStudent(createdAccount, it)
            }.onFailure {
                accountRepository.delete(createdAccount)
                throw it
            }
        }

        addAccountRequest.teacherInfo?.let {
            runCatching {
                teacherService.addTeacher(createdAccount, it)
            }.onFailure {
                accountRepository.delete(createdAccount)
                throw it
            }
        }

        if (addAccountRequest.isAdmin) {
            runCatching {
                adminService.addAdmin(createdAccount)
            }.onFailure {
                accountRepository.delete(createdAccount)
                throw it
            }
        }

        return createdAccount.id
    }

    fun getAccounts(): List<SummaryAccountDTO> = accountRepository.findAll().map(accountMapper::toSummaryDto)

    fun getAccount(id: UUID): AccountDTO =
        accountMapper.toDto(accountRepository.findById(id).orElseThrow { Exception() })
}