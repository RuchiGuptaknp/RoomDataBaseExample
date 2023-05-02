package com.example.roomdatabaseexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseexample.repository.NoteRepository
import com.example.roomdatabaseexample.room.Note
import com.example.roomdatabaseexample.room.NoteDataBase
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    val allNotes : LiveData<List<Note>>
    val noteRepository : NoteRepository
    init {
        val dao=NoteDataBase.getDatabase(application).getNoteDao()

        noteRepository= NoteRepository(dao)
        allNotes= noteRepository.allNotes
    }
    fun deleteDao(note: Note)=viewModelScope.launch {
        noteRepository.deleteDao(note)
    }
    fun updateDao(note: Note)=viewModelScope.launch {
        noteRepository.updateDao(note)
    }
    fun insertDao(note: Note)=viewModelScope.launch {
        noteRepository.insertNote(note)
    }

}