package com.example.roomdatabaseexample.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabaseexample.room.Note
import com.example.roomdatabaseexample.room.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes:LiveData<List<Note>> = noteDao.getAllNotes()
    suspend fun insertNote(note: Note){
       noteDao.insertNote(note)
    }
    suspend fun deleteDao(note: Note){
        noteDao.deleteNote(note)
    }
    suspend fun updateDao(note: Note){
        noteDao.getUpdateNote(note)
    }
}