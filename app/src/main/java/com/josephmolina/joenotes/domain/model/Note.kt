package com.josephmolina.joenotes.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.josephmolina.joenotes.ui.theme.BabyBlue
import com.josephmolina.joenotes.ui.theme.RedOrange
import com.josephmolina.joenotes.ui.theme.RedPink
import com.josephmolina.joenotes.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
      val noteColors = listOf(RedOrange, Color.LightGray, Violet, BabyBlue, RedPink)
    }
}
//Used to give detailed error messages for specific events
class InvalidNoteException(message: String) : Exception(message)