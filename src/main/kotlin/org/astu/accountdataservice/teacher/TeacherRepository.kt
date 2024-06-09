package org.astu.accountdataservice.teacher

import org.astu.accountdataservice.teacher.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TeacherRepository : JpaRepository<Teacher, UUID>, JpaSpecificationExecutor<Teacher>