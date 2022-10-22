package com.merttoptas.retrofittutorial.data.di

import com.merttoptas.retrofittutorial.data.remote.api.ApiService
import com.merttoptas.retrofittutorial.data.remote.api.UserApiService
import com.merttoptas.retrofittutorial.data.repository.UserRepository
import com.merttoptas.retrofittutorial.data.repository.UserRepositorylmpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
class UsersModule {

    @Provides
    fun provideApiService(retrofit: Retrofit) : UserApiService{
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    fun provideUserRepository(apiService: UserApiService) : UserRepository{
        return UserRepositorylmpl(apiService)
    }

}