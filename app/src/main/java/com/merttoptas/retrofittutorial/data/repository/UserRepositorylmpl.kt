package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.local.database.PostsDatabase
import com.merttoptas.retrofittutorial.data.local.database.entity.PostEntity
import com.merttoptas.retrofittutorial.data.model.Post
import com.merttoptas.retrofittutorial.data.model.Users
import com.merttoptas.retrofittutorial.data.remote.api.ApiService
import com.merttoptas.retrofittutorial.data.remote.api.UserApiService
import retrofit2.Call

class UserRepositorylmpl constructor(
    private val apiService: UserApiService
): UserRepository{
    override fun getUsers(): Call<List<Users>> {
        return apiService.getUsers()
    }
}