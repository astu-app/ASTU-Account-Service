package org.astu.accountdataservice.teacher

import org.astu.accountdataservice.account.controller.AddTeacherRequest
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.teacher.model.Teacher
import org.springframework.stereotype.Service

@Service
class TeacherService(
    private val teacherRepository: TeacherRepository,
) {
    fun addTeacher(account: Account, it: AddTeacherRequest) {
        val teacher = Teacher(account = account, title = it.title, role = it.role)
        teacherRepository.save(teacher)
    }
}