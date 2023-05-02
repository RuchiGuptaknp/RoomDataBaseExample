package com.example.roomdatabaseexample.adapter

import android.content.Context
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseexample.R

import com.example.roomdatabaseexample.room.Note
import com.example.roomdatabaseexample.utils.toastMessage

class NoteAdapter(
 private   val itemClickListener: itemClickListener,
    private val deleteClickListener: deleteClickListener,
   private val context: Context):RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val noteTitle = item.findViewById<TextView>(R.id.idTVNote)!!
        val noteDescription = item.findViewById<TextView>(R.id.idTVDescription)
        val noteDate = item.findViewById<TextView>(R.id.idTVDate)
        val noteDelete = item.findViewById<ImageView>(R.id.idIVDelete)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return allNotes.size
        context.toastMessage("${allNotes.size}")
    }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            context.toastMessage("${allNotes.size}")
            holder.noteTitle.text = allNotes[position].noteTitle
            holder.noteDescription.text = allNotes[position].noteDescription
            holder.noteDate.text = allNotes[position].timeStamp
            holder.noteDelete.setOnClickListener {
                deleteClickListener.deleteListener(allNotes[position])

            }
            holder.itemView.setOnClickListener {
                itemClickListener.itemListener(allNotes[position])

            }

        }
    fun updateNoteList(newList:List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }



}
interface deleteClickListener{
    fun  deleteListener(note: Note)

}
interface itemClickListener{
    fun  itemListener(note: Note)

}