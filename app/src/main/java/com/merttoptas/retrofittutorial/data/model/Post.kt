package com.merttoptas.retrofittutorial.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by merttoptas on 8.10.2022.
 */

data class Post(
    @SerializedName("body")
    val body: String?,
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?
)

data class PostDTO(
    val body: String?,
    val userId: Int?,
    val id: Long?,
    val title: String?,
    val isFavorite: Boolean = false
)