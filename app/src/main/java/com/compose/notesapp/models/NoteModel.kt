package com.compose.notesapp.models

data class NoteModel(
    val id: Int,
    val title: String,
    val description: String
)

fun dummyNotes() : List<NoteModel> {
    val items = arrayListOf<NoteModel>()

    for (i in 1..20) {
        items.add(
            NoteModel(i, "Title $i", description = "Description $i")
        )
    }
    return items
}