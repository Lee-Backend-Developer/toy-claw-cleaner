package com.apple.toyclawcleaner.user.entity

import com.apple.toyclawcleaner.common.entity.BaseTimeEntity
import jakarta.persistence.*
import lombok.ToString
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "users")
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

    /** 고유 UUID (PK) */
    @Id
    open var id: UUID = UUID.randomUUID()

) : BaseTimeEntity() {
    constructor() : this(loginId = "", password = "", name = "")

    override fun toString(): String {
        return "UserEntity(loginId='$loginId', password='$password', name='$name', role=$role, createdAt=$createdAt, updatedAt=$updatedAt, id=$id)"
    }

}

