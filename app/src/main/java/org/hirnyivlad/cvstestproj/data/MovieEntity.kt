package org.hirnyivlad.cvstestproj.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey
    val id:Int =-1,
    val image: Int? = null,
    val title: String ="",
    val description: String ="",
    val rating:Float =0f,
    val duration: String ="",
    val genre: String ="",
    val releasedDate:String="",
    val link: String="",
    val isAddedToWatchList: Boolean = false
)