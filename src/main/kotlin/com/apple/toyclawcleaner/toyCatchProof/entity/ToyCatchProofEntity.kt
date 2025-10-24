package com.apple.toyclawcleaner.toyCatchProof.entity

import com.apple.toyclawcleaner.common.entity.BaseTimeEntity
import com.apple.toyclawcleaner.franchise.entity.FranchiseEntity
import com.apple.toyclawcleaner.user.entity.UserEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "toyCatchProof")
class ToyCatchProofEntity(
    @Id
    @Column(name = "id", nullable = false, unique = true)
    var id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_fk", nullable = false)
    var user : UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "franchise_fk", nullable = false)
    var franchise : FranchiseEntity,

    var coin : Int = 0,
    var toyName : String = "",
    var count : Int = 0,

    ) : BaseTimeEntity() {


}