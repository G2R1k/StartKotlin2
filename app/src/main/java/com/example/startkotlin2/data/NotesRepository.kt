package com.example.startkotlin2.data

object NotesRepository{

    //private val notes: List<Note> = listOf()
    //private List<>() notes2 = new List<Notes>;
    private val notes = listOf<Note>(
        Note("Первая заметка",
        "Текст первой заметки.",
        0xfff06292.toInt()
        ),
        Note("Вторая заметка",
            "Текст второй заметки.",
            0xff9575cd.toInt()
        ),
        Note("Третья заметка",
            "Текст третьей заметки.",
            0xff64b5f6.toInt()
        ),
        Note("Четвертая заметка",
            "Текст четвертой заметки.",
            0xff4db6ac.toInt()
        ),
        Note("Пятая заметка",
            "Текст пятой заметки.",
            0xffb2ff59.toInt()
        ),
        Note("Шестая заметка",
            "Текст шестой заметки.",
            0xffffeb3b.toInt()
        )
    )

    fun getNotes(): List<Note>{
        return notes
    }
}