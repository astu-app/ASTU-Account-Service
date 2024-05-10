package org.astu.accountdataservice.teacher.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import org.astu.accountdataservice.account.model.Account
import java.util.*

@Entity
class Teacher (
    @Id
    val id: UUID = UUID.randomUUID(),
    @OneToOne
    @JoinColumn(name = "id")
    val account: Account,
    /**
     * Должность
     */
    val role: String,
    /**
     * Ученое звание
     */
    val title: String
)