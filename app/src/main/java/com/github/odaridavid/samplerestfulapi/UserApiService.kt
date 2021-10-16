package com.github.odaridavid.samplerestfulapi

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface UserApiService {

    @GET("/api/users")
    suspend fun getUsers(): UserListResponse

    companion object {

        fun createUserApiService(): UserApiService =
            Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(UserApiService::class.java)
    }
}
