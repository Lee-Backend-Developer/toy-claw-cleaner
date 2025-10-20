package com.apple.toyclawcleaner.user

import com.apple.toyclawcleaner.user.repostiory.UserRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
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

}