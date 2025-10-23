package com.apple.toyclawcleaner.franchise.entity

import com.apple.toyclawcleaner.common.entity.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "franchise")
class FranchiseEntity(
    @Id
    @Column(name = "id", nullable = false, unique = true)
    var id: String = "",
    var address_name : String = "",
    var road_address_name : String = "",
    var place_name : String = "",
    var x : Double = 0.0,
    var y : Double = 0.0,
) : BaseTimeEntity() {
    override fun toString(): String {
        return "FranchiseEntity(id='$id', address_name='$address_name', road_address_name='$road_address_name', place_name='$place_name', x=$x, y=$y)"
    }
}