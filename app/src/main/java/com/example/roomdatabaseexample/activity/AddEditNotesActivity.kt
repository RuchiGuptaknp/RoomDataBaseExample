package com.example.roomdatabaseexample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.roomdatabaseexample.R
import com.example.roomdatabaseexample.databinding.ActivityAddEditNotesBinding
import com.example.roomdatabaseexample.room.Note
import com.example.roomdatabaseexample.utils.toastMessage
import com.example.roomdatabaseexample.viewmodel.NoteViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddEditNotesActivity : AppCompatActivity() {
    private val binding by lazy {
             ActivityAddEditNotesBinding.inflate(layoutInflater) }
             private val viewModel:NoteViewModel by viewModels()
             var noteId=-1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //getting data from intent
        val noteType=intent.getStringExtra("noteType")
        if (noteType.equals("Edit")){
           val noteTitle=intent.getStringExtra("noteType")
            val noteDescription=intent.getStringExtra("noteDescription")
            noteId=intent.getIntExtra("noteId",-1)
            binding.idEdtNoteName.setText(noteTitle)
            binding.idEdtNoteDesc.setText(noteDescription)
            binding.idBtn.text="Update Button"
        }else{
            binding.idBtn.text="Save Button"
        }
        binding.idBtn.setOnClickListener {
            val nameTitle =binding.idEdtNoteName.text.toString()
            val description =binding.idEdtNoteDesc.text.toString()
            if (noteType.equals("Edit")){
                if (nameTitle.isNotEmpty()&&description.isNotEmpty()){
                    val sdf=SimpleDateFormat("dd MMM,yyyy")
                    val currentDateTime=sdf.format(Date())
                  val updateNote=Note(noteId,nameTitle,description,currentDateTime)
                    updateNote.Id=noteId
                    viewModel.updateDao(updateNote)
                    toastMessage("Note Updated")



                }
            }else{
                if (nameTitle.isNotEmpty()&&description.isNotEmpty()){
                    val sdf=SimpleDateFormat("dd MMM,yyyy")
                    val currentDateTime=sdf.format(Date())
                  viewModel.insertDao(Note(null,nameTitle,description,currentDateTime))
                    toastMessage("Added Note")


                }

            }
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }


    }
}