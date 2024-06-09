package org.astu.accountdataservice

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.astu.accountdataservice.university_data_client.UniversityConfig
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ping")
class PingController(val universityConfig: UniversityConfig) {
    @GetMapping
    suspend fun ping(): String {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
        val responses = mutableListOf<String>()

        runCatching {
            val response = client.get("${universityConfig.url}ping")
            responses.add("University data service: ${response.status}")
        }.onFailure {
            responses.add("University data service: [$it] ${it.message}")
        }
        return Json.encodeToString(responses)
    }
}