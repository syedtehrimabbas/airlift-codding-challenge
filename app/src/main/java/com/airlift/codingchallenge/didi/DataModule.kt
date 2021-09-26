package com.airlift.codingchallenge.didi

import com.airlift.networking.authentication.LayerApi
import com.airlift.networking.authentication.LayerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideLayerRepository(authRepository: LayerRepository): LayerApi
}