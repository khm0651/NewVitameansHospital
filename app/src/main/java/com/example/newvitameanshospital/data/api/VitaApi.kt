package com.example.newvitameanshospital.data.api

import com.example.newvitameanshospital.data.model.User
import retrofit2.http.GET

interface VitaApi {

    @GET("user")
    suspend fun getUser(): User
}
