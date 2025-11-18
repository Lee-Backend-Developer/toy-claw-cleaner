package com.apple.toyclawcleaner.toyCatchProof

import com.apple.toyclawcleaner.toyCatchProof.entity.ToyCatchProofEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface ToyCatchProofRepository : JpaRepository<ToyCatchProofEntity, UUID> {
    fun findByFranchiseId(franchiseId: String) : Optional<ToyCatchProofEntity>
}