package com.apple.toyclawcleaner.user.repostiory

import com.apple.toyclawcleaner.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
}