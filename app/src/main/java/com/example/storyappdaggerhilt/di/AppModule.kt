package com.example.storyappdaggerhilt.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.storyappdaggerhilt.data.local.UserPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "authentication")

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Provides
    @Singleton
    fun providesUserPreferences(
        dataStore: DataStore<Preferences>
    ) : UserPreferences {
        return UserPreferences(dataStore)
    }

    companion object {

        @Provides
        @Singleton
        fun provideDataStore(
            @ApplicationContext applicationContext: Context
        ) : DataStore<Preferences> {
            return applicationContext.dataStore
        }
    }
}