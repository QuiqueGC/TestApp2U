package com.example.testapp2u.di

import android.content.Context
import androidx.room.Room
import com.example.testapp2u.data.constants.MyConstants
import com.example.testapp2u.data.domain.repository.db.ArtistDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context, ArtistDB::class.java, MyConstants.DB_ARTIST_NAME
        ).build()

    @Singleton
    @Provides
    fun provideArtistDao(db: ArtistDB) = db.getArtistDao()
}