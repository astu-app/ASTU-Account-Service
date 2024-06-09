package org.astu.accountdataservice.admin

import org.astu.accountdataservice.admin.model.Admin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AdminRepository : JpaRepository<Admin, UUID>, JpaSpecificationExecutor<Admin>