package com.example.storyappdaggerhilt

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NetworkingViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val hardCodedToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1c2VyLXpGbWgxSHZaNTducHBwR00iLCJpYXQiOjE2ODI5OTk0MDR9.X3t6iVh3LMqz9RMQsIrYLC_uqJh1yCWMymfOjrfoRJY"

    companion object {
        private const val TAG = "Networking View Model"
    }

    fun login() {
        val loginRequest = LoginRequest(
            "adiva123@gmail.com",
            "123adiva"
        )
        val client = ApiConfig.getApiService().login(loginRequest)
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val token = response.body()!!.loginResult.token
                    setToken(token)
                    Log.i(TAG, "Login berhasil")
                } else {
                    Log.i(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })

    }

    fun setToken(token: String) {
        viewModelScope.launch {
            userPreferences.saveToken(token)
        }
    }
}