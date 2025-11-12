package com.apple.toyclawcleaner.toyCatchProof

import com.apple.toyclawcleaner.franchise.repository.FranchiseRepository
import com.apple.toyclawcleaner.toyCatchProof.entity.ToyCatchProofEntity
import com.apple.toyclawcleaner.toyCatchProof.request.ToyCatchProofCreate
import com.apple.toyclawcleaner.user.repostiory.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ToyCatchProofService(
    private val userRepository : UserRepository,
    private val franchiseRepository : FranchiseRepository,
    private val toyCatchProofRepository : ToyCatchProofRepository,
) {

    // DB에 뽑기 기록
    @Transactional
    fun createToyCatchProof(toyCatchProofCreate: ToyCatchProofCreate) {

        val user = userRepository.findById(toyCatchProofCreate.user)
            .orElseThrow { throw Exception("존재하지 않는 유저입니다.") }
        val franchise = franchiseRepository.findById(toyCatchProofCreate.franchise)
            .orElseThrow { throw Exception("존재하지 않는 프렌차이즈입니다.") }

        val toyCatchProofEntity = ToyCatchProofEntity(
            user = user,
            franchise = franchise,
            coin = toyCatchProofCreate.coin,
            toyName = toyCatchProofCreate.toyName,
            count = toyCatchProofCreate.count,
        )

        toyCatchProofRepository.save(toyCatchProofEntity)
    }

}