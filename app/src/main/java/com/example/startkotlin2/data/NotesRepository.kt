package com.example.startkotlin2.data

import androidx.lifecycle.MutableLiveData
import java.util.*

object NotesRepository{

    private val notesLiveData = MutableLiveData<List<Note>>()

    private val notes = mutableListOf(

        Note(
            UUID.randomUUID().toString(),
            "Первая заметка",
        "Текст первой заметки.",
            Note.Color.WHITE
        ),
        Note(
            UUID.randomUUID().toString(),
            "Вторая заметка",
            "Текст второй заметки.",
            Note.Color.YELLOW
        ),
        Note(
            UUID.randomUUID().toString(),
            "Третья заметка",
            "Текст третьей заметки.",
            Note.Color.GREEN
        ),
        Note(
            UUID.randomUUID().toString(),
            "Четвертая заметка",
            "Текст четвертой заметки.",
            Note.Color.BLUE
        ),
        Note(
            UUID.randomUUID().toString(),
            "Пятая заметка",
            "Текст пятой заметки.",
            Note.Color.RED
        ),
        Note(
            UUID.randomUUID().toString(),
            "Шестая заметка",
            "Текст шестой заметки.",
            Note.Color.VIOLET
        )
    )

    init {
        notesLiveData.value = notes
    }

    fun saveNote(note: Note){
        addOrReplace(note)
        notesLiveData.value = notes
    }

    fun addOrReplace(note: Note){
        for (i: Int in notes.indices){
            if(notes[i] == note){
                notes[i] = note
                return
            }
        }
        notes.add(note)
    }

    fun getNotes(): MutableLiveData<List<Note>> = NotesRepository.notesLiveData
}