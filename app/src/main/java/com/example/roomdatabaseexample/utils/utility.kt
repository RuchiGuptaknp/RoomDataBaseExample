package com.example.roomdatabaseexample.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toastMessage(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()

    fun Context.showVisibility(progressBar: ProgressBar){
       progressBar.visibility=View.VISIBLE
    }
    fun Context.hideVisibility(progressBar: ProgressBar){
        progressBar.visibility=View.GONE


    }
}