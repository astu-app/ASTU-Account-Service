package org.astu.accountdataservice.student.controller

import org.astu.accountdataservice.account.controller.AccountDTO
import org.astu.accountdataservice.student.StudentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/student")
class StudentController(private val studentService: StudentService) {
    @GetMapping("{id}")
    suspend fun getStudent(@PathVariable id: UUID): AccountDTO {
        return studentService.getStudent(id)
    }
}