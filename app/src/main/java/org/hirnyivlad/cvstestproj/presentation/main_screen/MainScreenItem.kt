package org.hirnyivlad.cvstestproj.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.hirnyivlad.cvstestproj.R
import org.hirnyivlad.cvstestproj.data.MovieEntity

@Composable
fun MainScreenItem(
    movie: MovieEntity,
    onClick: () -> Unit,
    year:String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(vertical = 10.dp)
            .clickable(onClick = onClick)
            .drawBehind {
                val underLinePath = Path().apply {
                    moveTo(0f, size.height + 22f)
                    lineTo(0f, size.height + 25f)
                    lineTo(size.width, size.height + 25f)
                    lineTo(size.width, size.height + 22f)
                    close()
                }
                drawPath(
                    path = underLinePath,
                    color = Color.LightGray
                )
            }
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(140.dp)
                .shadow(4.dp, RoundedCornerShape(10.dp))

        ) {
            Image(
                painter = painterResource(
                    id = movie.image ?: R.drawable.default_img
                ),
                contentDescription = "",
                modifier = Modifier
                    .size(145.dp, 195.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "${movie.title}($year)",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "${movie.duration} - ${movie.genre}",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            if (movie.isAddedToWatchList) {
                Text(
                    text = "ON MY WATCHLIST",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}