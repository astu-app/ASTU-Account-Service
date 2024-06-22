package org.astu.accountdataservice.exception

import org.springframework.http.HttpStatus

class CommonException(val status: HttpStatus, message: String) : RuntimeException(message)