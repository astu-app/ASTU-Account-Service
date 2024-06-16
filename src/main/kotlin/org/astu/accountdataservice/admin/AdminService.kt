package org.astu.accountdataservice.admin

import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.admin.model.Admin
import org.springframework.stereotype.Service

@Service
class AdminService(
    private val adminRepository: AdminRepository,
) {
    fun addAdmin(account: Account) {
        val admin = Admin(account = account)
        adminRepository.save(admin)
    }
}