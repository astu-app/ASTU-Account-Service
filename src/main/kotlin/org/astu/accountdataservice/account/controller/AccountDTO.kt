package org.astu.accountdataservice.account.controller

import org.astu.accountdataservice.employee.controller.EmployeeDTO
import org.astu.accountdataservice.student.controller.StudentDTO
import org.astu.accountdataservice.teacher.controller.TeacherDTO
import java.util.*

class AccountDTO(
    val id: UUID,
    /**
     * Имя участника сообщества АГТУ
     */
    val firstName: String,
    /**
     * Фамилия участника сообщества АГТУ
     */
    val secondName: String,
    /**
     * Отчество участника сообщества АГТУ
     */
    val patronymic: String? = null,

    /**
     * Флаг работника АГТУ
     */
    @set:JvmName("setIsEmployee")
    var isEmployee: Boolean,

    /**
     * Флаг студента АГТУ
     */
    @set:JvmName("setIsStudent")
    var isStudent: Boolean,

    /**
     * Флаг администратора АГТУ
     */
    @set:JvmName("setIsAdmin")
    var isAdmin: Boolean,

    /**
     * Флаг преподавателя АГТУ
     */
    @set:JvmName("setIsTeacher")
    var isTeacher: Boolean,

    val departmentId: UUID? = null,
    val studentGroupId: UUID? = null

    )