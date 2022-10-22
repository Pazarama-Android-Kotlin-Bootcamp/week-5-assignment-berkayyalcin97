package com.merttoptas.retrofittutorial.data.di

import com.merttoptas.retrofittutorial.data.local.database.PostsDatabase
import com.merttoptas.retrofittutorial.data.repository.FavPostRepository
import com.merttoptas.retrofittutorial.data.repository.FavPostRepositorytImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)

class FavPostModule {

    @Provides
    fun provideFavRepository(postsDatabase: PostsDatabase):FavPostRepository{
        return FavPostRepositorytImpl(postsDatabase)
    }
}