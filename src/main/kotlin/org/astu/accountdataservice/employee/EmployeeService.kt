package org.astu.accountdataservice.employee

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.withContext
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
    suspend fun addEmployee(account: Account, employeeInfo: AddEmployeeRequest) {
        val departmentId = departmentDataSource.getDepartmentId(employeeInfo.department)
        val employee = Employee(account = account, role = employeeInfo.role, departmentId = departmentId)
        withContext(Dispatchers.IO) {
            employeeRepository.save(employee)
        }
    }

    suspend fun getEmployee(departmentId: UUID, employeeId: UUID): AccountDTO {
        return accountMapper.toDto(
            withContext(Dispatchers.IO) {
                employeeRepository
                    .findByIdAndDepartmentId(employeeId, departmentId)
            }.orElseThrow { Exception() }
                .account
        )
    }
}