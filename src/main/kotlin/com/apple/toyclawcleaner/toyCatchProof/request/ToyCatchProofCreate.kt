package com.apple.toyclawcleaner.toyCatchProof.request

import com.apple.toyclawcleaner.common.Request
import java.util.UUID

class ToyCatchProofCreate(
    val user : UUID,
    val franchise: String,
    val coin : Int,
    val toyName : String,
    val count : Int,
) : Request() {
}