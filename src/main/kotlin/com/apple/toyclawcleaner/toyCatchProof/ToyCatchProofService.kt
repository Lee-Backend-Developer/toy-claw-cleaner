package com.apple.toyclawcleaner.toyCatchProof

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ToyCatchProofService(
    private val toyCatchProofRepository : ToyCatchProofRepository,
) {
    // DB에 뽑기 기록
}