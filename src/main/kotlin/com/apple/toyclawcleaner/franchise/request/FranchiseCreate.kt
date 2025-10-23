package com.apple.toyclawcleaner.franchise.request

data class FranchiseCreate(
    var id: String = "",
    var address_name : String = "",
    var road_address_name : String = "",
    var place_name : String = "",
    var x : Double = 0.0,
    var y : Double = 0.0,
)
