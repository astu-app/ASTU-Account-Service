package org.astu.accountdataservice.employee.controller

import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.employee.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/employee")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getEmployee(@RequestParam departmentId: UUID, @RequestParam employeeId: UUID): AccountDTO {
        return employeeService.getEmployee(departmentId, employeeId)
    }
}