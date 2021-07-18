package com.example.newvitameanshospital.data.repository

import com.example.newvitameanshospital.data.api.VitaApi
import com.example.newvitameanshospital.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val vitaApi: VitaApi
) {

    fun loadUser(): Flow<User> = flow {
        emit(vitaApi.getUser())
    }
}
