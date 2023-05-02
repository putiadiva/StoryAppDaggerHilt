package com.example.storyappdaggerhilt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.storyappdaggerhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dummyString = viewModel.getDummyStringFromVM()
        Log.i(TAG, "Dummy String: $dummyString")

        val testString = viewModel.getDependencyString()
        Log.i(TAG, "Test String: $testString")

        val token = viewModel.getToken()
        Log.i(TAG, "Token: $token")

        val btnToNetworking = binding.btnToNetworking
        btnToNetworking.setOnClickListener {
            val intent = Intent(this@MainActivity, NetworkingActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "Main Activity"
    }
}