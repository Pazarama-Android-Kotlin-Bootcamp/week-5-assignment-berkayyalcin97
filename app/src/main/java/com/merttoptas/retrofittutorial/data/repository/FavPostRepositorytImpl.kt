package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.local.database.PostsDatabase
import com.merttoptas.retrofittutorial.data.local.database.entity.PostEntity

class FavPostRepositorytImpl constructor(private val postsDatabase: PostsDatabase):FavPostRepository {

    override fun getFavPosts(): List<PostEntity> {
        return postsDatabase.postDao().getAllPosts()
    }
}