package com.compose.notesapp.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.compose.notesapp.models.NoteModel
import com.compose.notesapp.models.dummyNotes

class HomeScreenViewModel :ViewModel() {
    private val TAG = "HomeScreenViewModel"

    private val _notes = ArrayList<NoteModel>(dummyNotes())
    val notes = _notes.toList()

    fun listItemOnClick(id: Int) {
        Log.d(TAG, "listItemOnClick : $id")
    }

    fun addNewNote() {
        Log.d(TAG, "addNewNote: ")
    }
}