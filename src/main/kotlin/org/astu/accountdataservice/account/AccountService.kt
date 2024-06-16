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
            patronymic = addAccountRequest.patronymic,
            studentGroupId = addAccountRequest.studentGroupId,
            departmentId = addAccountRequest.departmentId
        )

        val createdAccount = accountRepository.save(account)
        return createdAccount.id
    }

    fun getAccounts(): List<SummaryAccountDTO> = accountRepository.findAll().map(accountMapper::toSummaryDto)

    fun getAccount(id: UUID): AccountDTO {
        println("start")
        val account = accountRepository.findAll().also { it.forEach  { println(it.id) }}.filter { it.id == id }.first()

        return AccountDTO(
            account.id,
            account.firstName,
            account.secondName,
            account.patronymic,
            account.departmentId != null,
            account.studentGroupId != null,
            isAdmin = false,
            isTeacher = false,
            departmentId = account.departmentId,
            studentGroupId = account.studentGroupId
        )
    }
}