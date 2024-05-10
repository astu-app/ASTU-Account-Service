package org.astu.accountdataservice.account

import org.astu.accountdataservice.account.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : JpaRepository<Account, UUID>, JpaSpecificationExecutor<Account>