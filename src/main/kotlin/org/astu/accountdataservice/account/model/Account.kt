package org.astu.accountdataservice.account.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import org.astu.accountdataservice.admin.model.Admin
import org.astu.accountdataservice.employee.model.Employee
import org.astu.accountdataservice.student.model.Student
import org.astu.accountdataservice.teacher.model.Teacher
import java.util.*

@Entity
class Account(
    @Id val id: UUID = UUID.randomUUID(),
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

    @OneToOne(mappedBy = "account", optional = true)
    var employee: Employee? = null,

    @OneToOne(mappedBy = "account", optional = true)
    var student: Student? = null,

    @OneToOne(mappedBy = "account", optional = true)
    var admin: Admin? = null,

    @OneToOne(mappedBy = "account", optional = true)
    val teacher: Teacher? = null
)
