package com.example.roomdatabaseexample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabaseexample.adapter.NoteAdapter
import com.example.roomdatabaseexample.adapter.deleteClickListener
import com.example.roomdatabaseexample.adapter.itemClickListener

import com.example.roomdatabaseexample.databinding.ActivityMainBinding
import com.example.roomdatabaseexample.room.Note
import com.example.roomdatabaseexample.utils.toastMessage
import com.example.roomdatabaseexample.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity(),deleteClickListener,itemClickListener {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel : NoteViewModel by  viewModels()
   private lateinit var  noteAdapter:NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()

        viewModel.allNotes.observe(this, Observer {list->
            list.let {
                noteAdapter.updateNoteList(it)
            }

        })

        binding.idFAB.setOnClickListener {
    val intent = Intent(this,AddEditNotesActivity::class.java)
    startActivity(intent)
}


    }

    private fun initRecyclerView() {
        binding.notesRV.layoutManager=LinearLayoutManager(this)
      noteAdapter=NoteAdapter(this@MainActivity,this@MainActivity,this)
       binding.notesRV.adapter=noteAdapter

    }

    override fun deleteListener(note: Note) {
      viewModel.deleteDao(note)
        toastMessage("${note.noteTitle}deleted")
    }


    override fun itemListener(note: Note) {
       val intent = Intent(this,AddEditNotesActivity::class.java)
        intent.putExtra("noteType","Edit")
        intent.putExtra("noteTitle",note.noteTitle)
        intent.putExtra("noteDescription",note.noteDescription)
        intent.putExtra("noteId",note.Id)
        startActivity(intent)
    }


}