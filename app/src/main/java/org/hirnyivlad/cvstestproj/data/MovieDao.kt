package org.hirnyivlad.cvstestproj.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllMovies(movies: List<MovieEntity>)

    @Update
    suspend fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM movieentity")
    fun  getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM movieentity where id=:id")
    fun  getMovieById(id:Int): MovieEntity


}