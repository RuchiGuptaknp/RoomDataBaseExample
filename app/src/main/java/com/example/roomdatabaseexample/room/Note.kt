package com.example.roomdatabaseexample.room

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Note")
data class Note (
    @PrimaryKey(autoGenerate = true)
    var Id : Int?=null,
    var noteTitle : String,
    var noteDescription : String,
    var timeStamp : String

        )

