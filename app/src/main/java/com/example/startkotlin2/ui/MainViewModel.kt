package com.example.startkotlin2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.startkotlin2.data.NotesRepository

class MainViewModel : ViewModel(){

    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        viewStateLiveData.value = MainViewState(NotesRepository.getNotes())
    }
//    val viewState
//    get() = viewStateLiveData as LiveData<MainViewState>

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}