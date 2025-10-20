package com.apple.toyclawcleaner.user

import com.apple.toyclawcleaner.user.entity.UserEntity
import com.apple.toyclawcleaner.user.repostiory.UserRepository
import com.apple.toyclawcleaner.user.request.UserSignIn
import com.apple.toyclawcleaner.user.request.UserSignUp
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository
) {
    /**
    * 회원가입
    * */
    @Transactional
    fun createUser(request: UserSignUp) : UserEntity {
        val userEntity = UserEntity(loginId = request.loginId, password = request.password, name = request.name)
        return userRepository.save(userEntity)
    }

    /**
     * 회원 로그인
     */
    fun loginUser(userSignIn: UserSignIn) : UserEntity {
        val foundUser = userRepository.findByLoginId(userSignIn.loginId)
        if (foundUser == null || foundUser.password != userSignIn.password) {
            throw EntityNotFoundException("로그인에 실패하였습니다.")
        }

        return foundUser
    }

    /**
     * 회원 탈퇴
     */
    @Transactional
    fun deleteUser(userId: UUID) {
        val user = userRepository.findById(userId)
            .orElseThrow { throw EntityNotFoundException("회원을 찾을수 없습니다.") }
        userRepository.delete(user)
    }
}