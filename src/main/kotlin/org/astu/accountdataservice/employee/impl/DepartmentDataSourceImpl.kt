package org.astu.accountdataservice.employee.impl

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import org.astu.accountdataservice.employee.DepartmentDataSource
import org.astu.accountdataservice.university_data_client.UniversityConfig
import org.astu.accountdataservice.university_data_client.api.DepartmentControllerApi
import org.springframework.stereotype.Component
import java.util.*

@Component
class DepartmentDataSourceImpl(private val config : UniversityConfig) : DepartmentDataSource {
    override suspend fun getDepartmentId(name: String): UUID {
        val client = HttpClient(CIO){
            install(ContentNegotiation) {
                json()
            }
        }

        val id = DepartmentControllerApi(client, config.url).getDepartments().first {
            it.name == name
        }.id

        return UUID.fromString(id)
    }
}