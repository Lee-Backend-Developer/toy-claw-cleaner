package com.apple.toyclawcleaner.franchise.repository

import com.apple.toyclawcleaner.franchise.entity.FranchiseEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FranchiseRepository : JpaRepository<FranchiseEntity, String>{
}