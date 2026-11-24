package com.example.prak4_vysotskiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "crime")
data class Crime(
    @PrimaryKey
    var id: Long = 0,
    var title: String = "",
    var date: String = "1.1.1999",
    var isSolved: Boolean = false,
    var suspect: String = "",
    var suspectPhone: String = ""
)