package org.astu.accountdataservice.student

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.account.controller.AddStudentRequest
import org.astu.accountdataservice.account.mapper.AccountMapperImpl
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.student.model.Student
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val studentGroupDatasource: StudentGroupDataSource,
    private val accountMapper: AccountMapperImpl
) {
    suspend fun addStudent(account: Account, it: AddStudentRequest) {
        val studentGroupId = studentGroupDatasource.getStudentGroupId(it.studentGroup)
        val student = Student(account = account, studentGroupId = studentGroupId)
        withContext(Dispatchers.IO) {
            studentRepository.save(student)
        }
    }

    suspend fun getStudent(studentId: UUID): AccountDTO {
        return accountMapper.toDto(
            withContext(Dispatchers.IO) {
                studentRepository
                    .findById(studentId)
            }.orElseThrow { Exception() }
                .account
        )
    }
}