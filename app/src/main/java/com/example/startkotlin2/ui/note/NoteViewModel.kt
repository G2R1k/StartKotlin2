package com.example.startkotlin2.ui.note

import androidx.lifecycle.ViewModel
import com.example.startkotlin2.data.Note
import com.example.startkotlin2.data.NotesRepository

class NoteViewModel(): ViewModel(){
    private var pendingNote: Note?= null

    fun save(note: Note){
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }
}