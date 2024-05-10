package org.astu.accountdataservice.account.controller

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
    val studentInfo: AddStudentRequest? = null,
    val employeeInfo: AddEmployeeRequest? = null
)

