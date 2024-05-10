package org.astu.accountdataservice.employee

import java.util.*

interface DepartmentDataSource {
    suspend fun getDepartmentId(name: String): UUID
}