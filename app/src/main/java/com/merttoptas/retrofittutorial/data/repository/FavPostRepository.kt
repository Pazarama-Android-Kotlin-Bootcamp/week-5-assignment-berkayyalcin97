package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.local.database.entity.PostEntity
import com.merttoptas.retrofittutorial.data.model.Post
import retrofit2.Call

interface FavPostRepository {



    fun getFavPosts():List<PostEntity>
}