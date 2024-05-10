package org.astu.accountdataservice.student.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import org.astu.accountdataservice.account.model.Account
import java.util.*

@Entity
class Student(
    @Id
    val id: UUID = UUID.randomUUID(),
    @OneToOne
    @JoinColumn(name = "id")
    val account: Account,
    val studentGroupId: UUID
)