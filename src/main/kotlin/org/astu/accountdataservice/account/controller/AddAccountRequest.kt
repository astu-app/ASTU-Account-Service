package org.astu.accountdataservice.account.controller

import java.util.*

class AddAccountRequest(
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
    val studentGroupId: UUID? = null
)

