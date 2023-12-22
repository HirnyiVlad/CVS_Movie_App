package org.hirnyivlad.cvstestproj.presentation.movie_details_screen

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.hirnyivlad.cvstestproj.data.MovieDataBase
import org.hirnyivlad.cvstestproj.data.MovieEntity
import javax.inject.Inject

@HiltViewModel
class MovieDetailsScreenViewModel @Inject constructor(
    private val movieDataBase: MovieDataBase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val movieId: String = checkNotNull(savedStateHandle["id"])
    private val _currentMovie = mutableStateOf<MovieEntity>(MovieEntity())
    val currentMovie: State<MovieEntity> = _currentMovie

    fun updateMovie() {
        viewModelScope.launch {
            _currentMovie.value = _currentMovie.value.copy(
                id = _currentMovie.value.id,
                image = _currentMovie.value.image,
                title = _currentMovie.value.title,
                description = _currentMovie.value.description,
                rating = _currentMovie.value.rating,
                duration = _currentMovie.value.duration,
                genre = _currentMovie.value.genre,
                releasedDate = _currentMovie.value.releasedDate,
                link = _currentMovie.value.link,
                isAddedToWatchList = !_currentMovie.value.isAddedToWatchList
            )
            movieDataBase.dao.updateMovie(_currentMovie.value)
        }
    }

    fun getMovieById() {
        viewModelScope.launch(Dispatchers.IO) {
            _currentMovie.value = movieDataBase.dao.getMovieById(movieId.toInt())
        }
    }

    fun openYouTube(context: Context) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(_currentMovie.value.link))
        intent.setPackage("com.google.android.youtube")
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            intent.setPackage("com.android.chrome")
            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}