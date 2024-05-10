package org.astu.accountdataservice.account.controller

import java.util.UUID

class SummaryAccountDTO(
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
    val patronymic: String? = null
)