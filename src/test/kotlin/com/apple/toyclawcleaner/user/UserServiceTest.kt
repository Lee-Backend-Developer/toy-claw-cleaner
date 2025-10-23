package com.apple.toyclawcleaner.user

import com.apple.toyclawcleaner.user.repostiory.UserRepository
import com.apple.toyclawcleaner.user.request.UserSignIn
import com.apple.toyclawcleaner.user.request.UserSignUp
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest(
    @Autowired
    var userRepository: UserRepository,
    @Autowired
    var userService: UserService
) {

    @BeforeEach
    fun setup() {
        /**
         * 테스트 코드 실행 할 때 동시에 같은 아이디를 생성할 때 오류가 나서
         * 테스트 코드 마다 실행 할 때 DB 초기화 진행
         */
        userRepository.deleteAll()
    }

    @DisplayName("회원이 저장이 되어야한다.")
    @Test
    fun `회원이_저장_되어야한다`() {
        // given
        val userSignUp : UserSignUp = UserSignUp(loginId = "test", password = "1234", name = "test")
        // when
        val createUser = userService.createUser(userSignUp)
        // then
        assertThat(1L).isEqualTo(userRepository.count())

    }

    @DisplayName("회원이 로그인이 되어야한다")
    @Test
    fun `회원이_로그인_되어야한다`() {
        // given
        val userSignUp : UserSignUp = UserSignUp(loginId = "test", password = "1234", name = "test")
        val createUser = userService.createUser(userSignUp)

        val userSignIn = UserSignIn(loginId = "test", password = "1234")

        // when
        val loginUser = userService.loginUser(userSignIn)
        // then
        assertThat(loginUser.loginId).isEqualTo("test")
    }

    @DisplayName("회원 탈퇴가 되어야한다.")
    @Test
    fun `회원 탈퇴가_되어야한다`() {
        // given
        val userSignUp : UserSignUp = UserSignUp(loginId = "test", password = "1234", name = "test")
        val createUser = userService.createUser(userSignUp)
        // when
        userService.deleteUser(createUser.id)

        // then
        assertThat(0L).isEqualTo(userRepository.count())
    }

}