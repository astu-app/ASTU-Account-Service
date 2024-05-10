package org.astu.accountdataservice.student

import java.util.*

interface StudentGroupDataSource {
    suspend fun getStudentGroupId(studentGroup: String): UUID
}