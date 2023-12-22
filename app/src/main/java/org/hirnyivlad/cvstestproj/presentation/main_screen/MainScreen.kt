package org.hirnyivlad.cvstestproj.presentation.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.hirnyivlad.cvstestproj.presentation.main_screen.sort_dialog.SortDialog

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    LaunchedEffect(viewModel) {
        viewModel.insertAllMovies()
        viewModel.onLaunch()
    }

    val allMovies by viewModel.movies.collectAsState(initial = emptyList())
    val dialogState by remember {
        viewModel.dialogState
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            viewModel.updateDialogState(true)
                        },
                    ) {
                        Text(
                            text = "Sort",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        )
                    }
                }
            }
            item {
                Text(
                    text = "Movies",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            items(allMovies) { movie ->
                MainScreenItem(movie = movie,
                    onClick = {
                        navController.navigate("details_screen/${movie.id}")
                    },
                    year = viewModel.getCurrentYear(movie.releasedDate))
            }
        }
        if (dialogState.showDialog) {
            SortDialog(onDialogDismiss = { viewModel.updateDialogState(false) },
                onDialogSubmitTitle = {
                    viewModel.sortByTitle()
                    viewModel.updateDialogState(false)
                },
                onDialogSubmitDate = {
                    viewModel.sortByDate()
                    viewModel.updateDialogState(false)
                }
            )
        }
    }
}