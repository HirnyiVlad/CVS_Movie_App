package org.hirnyivlad.cvstestproj.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.hirnyivlad.cvstestproj.data.MovieDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMovieDataBase(@ApplicationContext context: Context): MovieDataBase{
        return Room.databaseBuilder(
            context,
            MovieDataBase::class.java,
            "movie_db"
        ).build()
    }
}