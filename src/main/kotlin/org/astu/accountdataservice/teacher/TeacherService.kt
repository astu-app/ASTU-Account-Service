package org.astu.accountdataservice.teacher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.astu.accountdataservice.account.controller.AddTeacherRequest
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.teacher.model.Teacher
import org.springframework.stereotype.Service

@Service
class TeacherService(
    private val teacherRepository: TeacherRepository,
) {
    suspend fun addTeacher(account: Account, it: AddTeacherRequest) {
        val teacher = Teacher(account = account, title = it.title, role = it.role)
        withContext(Dispatchers.IO) {
            teacherRepository.save(teacher)
        }
    }
}