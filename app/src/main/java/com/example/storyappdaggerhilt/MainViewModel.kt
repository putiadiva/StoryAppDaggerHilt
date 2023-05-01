package com.example.storyappdaggerhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.storyappdaggerhilt.data.local.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    fun getToken() : LiveData<String> {
        return userPreferences.getToken().asLiveData()
    }

    suspend fun setToken() {
        return userPreferences.saveToken("dummytoken")
    }
}