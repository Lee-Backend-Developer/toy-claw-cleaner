package com.apple.toyclawcleaner.user.repostiory

import com.apple.toyclawcleaner.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserEntity, UUID> {
}