package com.compose.notesapp.addnotes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.notesapp.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    private val TAG = "AddNoteViewModel"

    private var _title = MutableStateFlow("")
    val title = _title.asStateFlow()
    private var _description = MutableStateFlow("")
    val description = _description.asStateFlow()

    private val _event = MutableSharedFlow<Event>()
    val event = _event.asSharedFlow()

    fun titleOnValueChange(value: String) {
        Log.d(TAG, "titleOnValueChange: $value")
    }

    fun descriptionOnValueChange(value: String) {
        _description.value = value
    }

    fun backIconOnClick() {
        val noteModel = NoteModel(
            id = -1,
            title = _title.value,
            description = _description.value
        )

        //save note


        //Navigate Back
        viewModelScope.launch (Dispatchers.Main) {
            _event.emit(Event.NavigateBack(noteModel))
        }
    }

    sealed class Event {
        data class NavigateBack(val note: NoteModel) : Event()
    }
}