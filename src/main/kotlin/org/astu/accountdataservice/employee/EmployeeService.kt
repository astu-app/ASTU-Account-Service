package org.astu.accountdataservice.employee

import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.account.controller.AddEmployeeRequest
import org.astu.accountdataservice.account.mapper.AccountMapper
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.employee.model.Employee
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(
    val departmentDataSource: DepartmentDataSource,
    private val employeeRepository: EmployeeRepository, private val accountMapper: AccountMapper
) {
    fun addEmployee(account: Account, employeeInfo: AddEmployeeRequest) {
//        val departmentId = departmentDataSource.getDepartmentId(employeeInfo.department)
//        val employee = Employee(account = account, role = employeeInfo.role, departmentId = departmentId)
        val id = UUID.fromString(employeeInfo.departmentId)
        val employee = Employee(account = account, role = employeeInfo.role, departmentId = id)
        employeeRepository.save(employee)
    }

    fun getEmployee(departmentId: UUID, employeeId: UUID): AccountDTO {
        return accountMapper.toDto(
            employeeRepository
                .findByIdAndDepartmentId(employeeId, departmentId).orElseThrow().account
        )
    }
}