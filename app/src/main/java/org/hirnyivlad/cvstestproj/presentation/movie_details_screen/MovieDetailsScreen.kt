package org.hirnyivlad.cvstestproj.presentation.movie_details_screen

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.hirnyivlad.cvstestproj.R
import org.hirnyivlad.cvstestproj.data.MovieEntity

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    LaunchedEffect(viewModel) {
        viewModel.getMovieById()
    }
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth().height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Sharp.KeyboardArrowLeft,
                    contentDescription = "Back",
                    modifier = Modifier.size(40.dp)
                )
            }
            Text(text = "Movies",
                modifier= Modifier.fillMaxWidth())
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = Color.LightGray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .width(140.dp)
                    .shadow(4.dp, RoundedCornerShape(10.dp))

            ) {
                Image(
                    painter = painterResource(
                        id = viewModel.currentMovie.value.image ?: R.drawable.default_img
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .size(145.dp, 195.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = viewModel.currentMovie.value.title,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                    )
                    TextRatingStyled(
                        rating = "${viewModel.currentMovie.value.rating}",
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                TextButton(
                    onClick = viewModel::updateMovie,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.LightGray)
                        .height(40.dp)
                ) {
                    if (viewModel.currentMovie.value.isAddedToWatchList) {
                        Text(
                            text = "REMOVE FROM MY WATCHLIST",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        )
                    } else {
                        Text(
                            text = "+ADD TO MY WATCHLIST",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                TextButton(
                    onClick = { viewModel.openYouTube(context) },
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .height(40.dp)
                        .width(165.dp)
                ) {
                    Text(
                        text = "WATCH TRAILER",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    )
                }
            }
        } //Row with image ends.
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            color = Color.LightGray
        )
        Text(
            text = "Short description",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = viewModel.currentMovie.value.description,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray
            ),
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            color = Color.LightGray
        )
        Text(
            text = "Details",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(12.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Genre",
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "Released date",
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = viewModel.currentMovie.value.genre,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    text = viewModel.currentMovie.value.releasedDate,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )
            }
        }
    }
}