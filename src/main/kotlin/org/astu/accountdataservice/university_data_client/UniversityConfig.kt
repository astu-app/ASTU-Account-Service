package org.astu.accountdataservice.university_data_client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class UniversityConfig (
    @Value("\${service.url}")
    private val serviceUrl: String
){
    val url: String
        get() {
            if(serviceUrl.endsWith("/"))
                return serviceUrl
            return "$serviceUrl/"
        }
}