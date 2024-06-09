package org.astu.accountdataservice.employee

import org.astu.accountdataservice.employee.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EmployeeRepository : JpaRepository<Employee, UUID>, JpaSpecificationExecutor<Employee>{
    fun findByIdAndDepartmentId(id: UUID, departmentId: UUID): Optional<Employee>
}