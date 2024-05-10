package org.astu.accountdataservice.account.mapper

import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.account.controller.AddAccountRequest
import org.astu.accountdataservice.account.controller.SummaryAccountDTO
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.employee.controller.EmployeeDTO
import org.astu.accountdataservice.employee.model.Employee
import org.astu.accountdataservice.student.controller.StudentDTO
import org.astu.accountdataservice.student.model.Student
import org.astu.accountdataservice.teacher.controller.TeacherDTO
import org.astu.accountdataservice.teacher.model.Teacher
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface AccountMapper {

    fun toEntity(addAccountRequest: AddAccountRequest): Account
    fun toSummaryDto(account: Account): SummaryAccountDTO

    @Mappings(
        Mapping(target = "isAdmin", expression = "java(account.getAdmin() != null)"),
        Mapping(target = "isEmployee", expression = "java(account.getEmployee() != null)"),
        Mapping(target = "isStudent", expression = "java(account.getStudent() != null)"),
        Mapping(target = "isTeacher", expression = "java(account.getTeacher() != null)"),
        Mapping(target = "studentInfo", expression = "java(toDto(account.getStudent()))"),
        Mapping(target = "teacherInfo", expression = "java(toDto(account.getTeacher()))"),
        Mapping(target = "employeeInfo", expression = "java(toDto(account.getEmployee()))"),
    )
    fun toDto(account: Account): AccountDTO

    fun toDto(student: Student?): StudentDTO?

    fun toDto(teacher: Teacher?): TeacherDTO?
    fun toDto(employee: Employee?): EmployeeDTO?
}