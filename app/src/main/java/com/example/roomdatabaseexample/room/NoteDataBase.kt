package com.example.roomdatabaseexample.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false )
abstract class NoteDataBase:RoomDatabase() {
    abstract fun getNoteDao():NoteDao
    companion object{
        @Volatile
        private var instance:NoteDataBase?=null
        fun getDatabase(context: Context):NoteDataBase{
            return instance ?: synchronized(this){
                val instances = Room.databaseBuilder(context.applicationContext,NoteDataBase::class.java,"note_database")
                    .build()
                instance= instances
                instances
            }
        }

    }


}
