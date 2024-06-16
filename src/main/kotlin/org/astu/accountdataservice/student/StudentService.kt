package org.astu.accountdataservice.student

import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.account.controller.AddStudentRequest
import org.astu.accountdataservice.account.mapper.AccountMapper
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.student.model.Student
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val studentGroupDatasource: StudentGroupDataSource,
    private val accountMapper: AccountMapper
) {
    fun addStudent(account: Account, it: AddStudentRequest) {
//        val studentGroupId = studentGroupDatasource.getStudentGroupId(it.studentGroup)
//        val student = Student(account = account, studentGroupId = studentGroupId)
        val id = UUID.fromString(it.studentGroupId)
        val student = Student(account = account, studentGroupId = id)
        studentRepository.save(student)
    }

    fun getStudent(studentId: UUID): AccountDTO {
        return accountMapper.toDto(
            studentRepository
                .findById(studentId)
                .orElseThrow { Exception() }
                .account
        )
    }
}