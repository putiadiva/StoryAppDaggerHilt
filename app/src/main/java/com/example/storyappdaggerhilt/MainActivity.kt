package com.example.storyappdaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dummyString = viewModel.getDummyStringFromVM()
        Log.i(TAG, "Dummy String: $dummyString")

        val testString = viewModel.getDependencyString()
        Log.i(TAG, "Test String: $testString")

        val token = viewModel.getToken()
        Log.i(TAG, "Token: $token")
    }

    companion object {
        private const val TAG = "Main Activity"
    }
}