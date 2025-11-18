package com.apple.toyclawcleaner.toyCatchProof

import com.apple.toyclawcleaner.franchise.entity.FranchiseEntity
import com.apple.toyclawcleaner.franchise.repository.FranchiseRepository
import com.apple.toyclawcleaner.toyCatchProof.entity.ToyCatchProofEntity
import com.apple.toyclawcleaner.toyCatchProof.request.ToyCatchProofCreate
import com.apple.toyclawcleaner.user.entity.UserEntity
import com.apple.toyclawcleaner.user.repostiory.UserRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ToyCatchProofServiceTest(
    @Autowired
    val toyCatchProofRepository: ToyCatchProofRepository,
    @Autowired
    val toyCatchProofService: ToyCatchProofService,
    @Autowired
    val userRepository: UserRepository,
    @Autowired
    val franchiseRepository: FranchiseRepository,
) {

    // 각 테스트 실행 전 데이터 설정
    @BeforeEach
    fun setup() {
        createUser()
        createFranchise()
    }


    // 각 테스트 끝날때 마다 삭제
    @AfterEach
    fun afterEach() {
        toyCatchProofRepository.deleteAll()
        userRepository.deleteAll()
        franchiseRepository.deleteAll()
    }

    @DisplayName("DB에 뽑기 기록이 저장이 되어야한다")
    @Test
    fun `DB에_뽑기_기록이_저장이_되어야한다`() {
        // given
        // 회원
        val user = getUser()
        // 프렌차이즈
        val franchise = getFranchise()
        // 코인
        val coin = 1000
        val toyCatchProofCreate = ToyCatchProofCreate(
            user = user!!.id,
            franchise = franchise!!.id,
            coin = coin,
            toyName = "Toy",
            count = 1
        )


        // when
        toyCatchProofService.createToyCatchProof(toyCatchProofCreate)

        // then
        assertThat(toyCatchProofRepository.findAll().size).isEqualTo(1)
    }

    @DisplayName("DB에 뽑기 기록이 조회가 되어야한다")
    @Test
    fun `DB에_뽑기_기록이_조회가_되어야한다`() {
        // given
        // 회원
        val user : UserEntity? = getUser()
        // 프렌차이즈
        val franchise : FranchiseEntity? = getFranchise()
        // 코인
        val coin = 1000
        val toyCatchProof = ToyCatchProofEntity(
            user = user!!,
            franchise = franchise!!,
            coin = coin,
            toyName = "Toy",
            count = 1
        )
        toyCatchProofRepository.save(toyCatchProof)

        // when
        val findToyCatchProof = toyCatchProofService.findToyCatchProof(franchise.id)

        // then
        assertThat(toyCatchProofRepository.findAll().size).isEqualTo(1)
        assertThat(findToyCatchProof!!.id).isEqualTo(toyCatchProof.id)
        assertThat(findToyCatchProof.toyName).isEqualTo(toyCatchProof.toyName)
    }

    // 유저 가져오기
    fun getUser() : UserEntity? {
        return userRepository.findByLoginId("test")
    }

    // 가맹점 가져오기
    fun getFranchise() : FranchiseEntity? {
        return franchiseRepository.findAll().first()
//        return franchiseRepository.findById("1234").orElseThrow { throw Exception("존재하지 않는 가맹점입니다.") }
    }

    // 유저 생성
    fun createUser() {
        val userEntity = UserEntity(loginId = "test", password = "1234", name = "test")
        userRepository.save(userEntity)
    }

    // 가맹점 생성
    fun createFranchise() {
        val franchiseEntity = FranchiseEntity(
            id = "1234",
            address_name = "경기도 어딘가",
            road_address_name = "경기도 도로",
            place_name = "인형뽑기싹쓰리",
            x = 0.11111,
            y = 0.111111
        )
        franchiseRepository.save(franchiseEntity)
    }

}