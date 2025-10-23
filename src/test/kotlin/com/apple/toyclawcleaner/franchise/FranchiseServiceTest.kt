package com.apple.toyclawcleaner.franchise

import com.apple.toyclawcleaner.franchise.entity.FranchiseEntity
import com.apple.toyclawcleaner.franchise.repository.FranchiseRepository
import com.apple.toyclawcleaner.franchise.request.FranchiseCreate
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
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

    @BeforeEach
    fun setup() {
        /**
         * 테스트 코드 실행 할 때 동시에 같은 아이디를 생성할 때 오류가 나서
         * 테스트 코드 마다 실행 할 때 DB 초기화 진행
         */
        franchiseRepository.deleteAll()
    }

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
        assertThat(franchiseRepository.findAll().size).isEqualTo(1)
    }

    @DisplayName("DB에 가맹점이 조회가 되어야한다")
    @Test
    fun `DB에_가맹점이_조회가_되어야한다`() {
        // given
        val franchiseCreate : FranchiseEntity = FranchiseEntity(
            id = "1234",
            address_name = "경기도 어딘가",
            road_address_name = "경기도 도로",
            place_name = "인형뽑기싹쓰리",
            x = 0.11111,
            y = 0.111111
        )
        franchiseRepository.save(franchiseCreate)

        // when
        val getFranchise = franchiseService.getFranchise(franchiseCreate.id)

        // then
        assertThat(getFranchise!!.id).isEqualTo(franchiseCreate.id)
    }

    @DisplayName("DB에 가맹점이 삭제가 되어야한다")
    @Test
    fun `DB에_가맹점이_삭제가_되어야한다`() {
        // given
        val franchiseCreate : FranchiseEntity = FranchiseEntity(
            id = "1234",
            address_name = "경기도 어딘가",
            road_address_name = "경기도 도로",
            place_name = "인형뽑기싹쓰리",
            x = 0.11111,
            y = 0.111111
        )
        franchiseRepository.save(franchiseCreate)

        // when
        franchiseService.deleteFranchise(franchiseCreate.id)

        // then
        assertThat(franchiseRepository.findAll().size).isEqualTo(0)
    }

}