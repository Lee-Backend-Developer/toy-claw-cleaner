package com.apple.toyclawcleaner.user

import com.apple.toyclawcleaner.user.entity.UserEntity
import com.apple.toyclawcleaner.user.repostiory.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository
) {
    /*
    * 사용자가 저장이 되어야한다
    * */
    @Transactional
    fun createUser(request: UserSignUp) : UserEntity {
        val userEntity = UserEntity(loginId = request.loginId, password = request.password, name = request.name)
        return userRepository.save(userEntity)
    }
}