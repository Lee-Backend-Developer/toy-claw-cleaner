package com.apple.toyclawcleaner.franchise

import com.apple.toyclawcleaner.franchise.repository.FranchiseRepository
import com.apple.toyclawcleaner.franchise.request.FranchiseCreate
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FranchiseServiceTest(
    @Autowired
    val franchiseRepository: FranchiseRepository,
    @Autowired
    val franchiseService: FranchiseService
) {

    @DisplayName("DB에 가맹점이 생성이 되어야한다")
    @Test
    fun `DB에_가맹점이_생성이_되어야한다`() {
        // given
        val franchiseCreate : FranchiseCreate = FranchiseCreate(
            id = "1234",
            address_name = "경기도 어딘가",
            road_address_name = "경기도 도로",
            place_name = "인형뽑기싹쓰리",
            x = 0.11111,
            y = 0.111111
        )

        // when
        franchiseService.createFranchise(franchiseCreate)

        // then
        Assertions.assertThat(franchiseRepository.findAll().size).isEqualTo(1)
    }

}