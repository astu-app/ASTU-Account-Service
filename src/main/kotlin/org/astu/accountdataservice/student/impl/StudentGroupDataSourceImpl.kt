package org.astu.accountdataservice.student.impl

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import org.astu.accountdataservice.student.StudentGroupDataSource
import org.astu.accountdataservice.university_data_client.UniversityConfig
import org.astu.accountdataservice.university_data_client.api.StudentGroupControllerApi
import org.springframework.stereotype.Component
import java.util.*

@Component
class StudentGroupDataSourceImpl(private val config : UniversityConfig) : StudentGroupDataSource {
    override suspend fun getStudentGroupId(studentGroup: String): UUID {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }

        val id = StudentGroupControllerApi(client, config.url).getAllStudentGroups().first {
            it.name == studentGroup
        }.id

        return UUID.fromString(id)
    }
}