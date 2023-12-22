package org.hirnyivlad.cvstestproj.presentation.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.hirnyivlad.cvstestproj.data.MovieDataBase
import org.hirnyivlad.cvstestproj.data.MovieEntity
import org.hirnyivlad.cvstestproj.domain.MovieList
import org.hirnyivlad.cvstestproj.presentation.main_screen.sort_dialog.DialogState
import java.sql.Struct
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val movieDataBase: MovieDataBase
) : ViewModel() {

    private val _dialogState = mutableStateOf(DialogState())
    val dialogState: State<DialogState> = _dialogState

    private val _movies = MutableStateFlow<List<MovieEntity>>(emptyList())
    val movies: StateFlow<List<MovieEntity>> = _movies

    private var isSortedByTitle = false
    private var isSortedByDate = false

    private fun getAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val allMovies = movieDataBase.dao.getAllMovies()
            _movies.value = allMovies
        }
    }

    fun insertAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            movieDataBase.dao.insertAllMovies(movies = MovieList.movies)
        }
    }

    fun updateDialogState(state: Boolean) {
        _dialogState.value = _dialogState.value.copy(showDialog = state)
    }

    fun sortByTitle() {
        viewModelScope.launch(Dispatchers.IO) {
            val allMovies = movieDataBase.dao.getAllMovies()
            _movies.value = allMovies.sortedBy { it.title }
            isSortedByTitle = true
            isSortedByDate = false
        }
    }

    fun sortByDate() {
        viewModelScope.launch(Dispatchers.IO) {
            val allMovies = movieDataBase.dao.getAllMovies()
            _movies.value = allMovies.sortedBy {
                SimpleDateFormat(
                    "yyyy, d MMMM",
                    Locale.ENGLISH
                )
                    .parse(it.releasedDate.trim())
            }
            isSortedByDate = true
            isSortedByTitle = false
        }
    }

    fun onLaunch() {
        if (isSortedByTitle) {
            sortByTitle()
        } else if (isSortedByDate) {
            sortByDate()
        } else {
            getAllMovies()
        }
    }

    fun getCurrentYear(fullDate: String) : String{
        val parts = fullDate.split(", ")
        return if (parts.isNotEmpty()) {
            parts[0]
        } else {
            ""
        }
    }
}