package org.astu.accountdataservice.admin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.astu.accountdataservice.account.model.Account
import org.astu.accountdataservice.admin.model.Admin
import org.springframework.stereotype.Service

@Service
class AdminService(
    private val adminRepository: AdminRepository,
) {
    suspend fun addAdmin(account: Account) {
        val admin = Admin(account = account)
        withContext(Dispatchers.IO) {
            adminRepository.save(admin)
        }
    }
}