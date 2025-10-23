package com.apple.toyclawcleaner.common.entity

import jakarta.persistence.Column
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

abstract class BaseTimeEntity (
    /** 생성일시 */
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    open var createdAt: LocalDateTime = LocalDateTime.now(),

    /** 수정일시 */
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    open var updatedAt: LocalDateTime = LocalDateTime.now(),
)