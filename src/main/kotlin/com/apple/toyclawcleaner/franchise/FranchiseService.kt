package com.apple.toyclawcleaner.franchise

import com.apple.toyclawcleaner.franchise.entity.FranchiseEntity
import com.apple.toyclawcleaner.franchise.repository.FranchiseRepository
import com.apple.toyclawcleaner.franchise.request.FranchiseCreate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class FranchiseService(
    private val franchiseRepository: FranchiseRepository
) {
    // 가맹점 생성
    @Transactional
    fun createFranchise(franchiseCreate: FranchiseCreate) {
        val franchiseEntity : FranchiseEntity = FranchiseEntity(
            id = franchiseCreate.id,
            address_name = franchiseCreate.address_name,
            road_address_name = franchiseCreate.road_address_name,
            place_name = franchiseCreate.place_name,
            x = franchiseCreate.x,
            y = franchiseCreate.y,
        )

        franchiseRepository.save(franchiseEntity)

    }

    // 가맹점 조회

    // 가맹점 삭제
}