package org.astu.accountdataservice.employee.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import org.astu.accountdataservice.account.model.Account
import java.util.UUID

@Entity
class Employee(
    @Id
    val id: UUID = UUID.randomUUID(),
    @OneToOne
    @JoinColumn(name = "id")
    val account: Account,
    val role: String,
    val departmentId: UUID
)