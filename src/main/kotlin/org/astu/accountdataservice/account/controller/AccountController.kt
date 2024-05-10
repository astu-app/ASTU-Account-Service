package org.astu.accountdataservice.account.controller

import org.astu.accountdataservice.account.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/account")
class AccountController(private val accountService: AccountService) {

    @PostMapping
    suspend fun createAccount(request: AddAccountRequest): UUID = accountService.addAccount(request)

    @GetMapping
    fun getAllAccounts(): List<SummaryAccountDTO> = accountService.getAccounts()

    @GetMapping("{id}")
    fun getAccountById(@PathVariable id: UUID): AccountDTO = accountService.getAccount(id)
}