package com.example.roomdatabaseexample.room

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun insertNote(note: Note)
    @Delete
   suspend fun deleteNote(note: Note)
    @Query("Select * from Note order by id ASC")
    fun getAllNotes():LiveData<List<Note>>
    @Update
    suspend fun getUpdateNote(note: Note)
}