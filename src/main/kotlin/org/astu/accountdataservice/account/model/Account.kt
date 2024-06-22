package org.astu.accountdataservice.account.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
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
    val departmentId: UUID? = null,
    val studentGroupId: UUID? = null,
    val admin: Boolean = false
)
