package com.example.sdu_portal_mobile.di

import com.example.sdu_portal_mobile.data.location.DefaultLocationTracker
import com.example.sdu_portal_mobile.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocatioTracker(defaultLocationTracker: DefaultLocationTracker) : LocationTracker
}