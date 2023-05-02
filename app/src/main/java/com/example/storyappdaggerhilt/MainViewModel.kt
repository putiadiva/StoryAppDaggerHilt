package com.example.storyappdaggerhilt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val testString: String,
    private val userPreferences: UserPreferences
) : ViewModel() {

    fun getDummyStringFromVM(): String {
        return "dummy"
    }

    fun getDependencyString(): String {
        return "test form dependency: $testString"
    }

    fun getToken(): String {
        return runBlocking { userPreferences.getToken().first() }
    }
}