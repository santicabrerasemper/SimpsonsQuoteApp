package com.example.thesimpsonsquoteapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesimpsonsquoteapp.core.RetrofitClient
import com.example.thesimpsonsquoteapp.models.SimpsonCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private var _charactersList = MutableLiveData<List<SimpsonCharacter>>()
    val charactersList: LiveData<List<SimpsonCharacter>> get() = _charactersList

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getCharacters()
            withContext(Dispatchers.Main) {
                _charactersList.value = response.body()
            }
        }
    }

    fun getCharacter(character: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getCharacter(character)
            withContext(Dispatchers.Main) {
                _charactersList.value = response.body()
            }
        }
    }

}