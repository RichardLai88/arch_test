package com.lzbtech.arch_test.repository.api.user

import com.lzbtech.arch_test.repository.model.UserInfoModel

class UserRepository {

    suspend fun getUserInfo(): UserInfoModel {
        return UserInfoModel("Richard.Lai", 18)
    }
}