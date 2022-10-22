package com.merttoptas.retrofittutorial.data.remote.api

import com.merttoptas.retrofittutorial.data.model.Post
import com.merttoptas.retrofittutorial.data.model.Users
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET("users")
    fun getUsers(): Call<List<Users>>

}