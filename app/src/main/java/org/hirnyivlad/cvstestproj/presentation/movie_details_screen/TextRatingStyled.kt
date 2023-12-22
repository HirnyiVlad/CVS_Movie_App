package org.hirnyivlad.cvstestproj.presentation.movie_details_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TextRatingStyled(
    rating: String,
    modifier: Modifier
) {
    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(rating)
        }
        withStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                color = Color.Gray
            )
        ) {
            append("/10")
        }
    }
    Text(text = text)
}