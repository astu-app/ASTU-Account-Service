package org.astu.accountdataservice.student

import org.astu.accountdataservice.student.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.*

interface StudentRepository : JpaRepository<Student, UUID>, JpaSpecificationExecutor<Student>