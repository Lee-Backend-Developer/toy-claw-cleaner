package com.apple.toyclawcleaner.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user")
class UserEntity(
    /** 회원 로그인 ID (이메일 또는 아이디) */
    @Column(name = "login_id", nullable = false, unique = true, length = 100)
    open var loginId: String,

    /** 비밀번호 (BCrypt 등으로 암호화된 문자열) */
    @Column(nullable = false, length = 255)
    open var password: String,

    /** 이름 */
    @Column(nullable = false, length = 50)
    open var name: String,

    /** 역할 */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    open var role: UserRole = UserRole.USER,

    /** 생성일시 */
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    open var createdAt: LocalDateTime = LocalDateTime.now(),

    /** 수정일시 */
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    open var updatedAt: LocalDateTime = LocalDateTime.now(),

    /** 고유 UUID (PK) */
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    open var id: UUID? = null

)

