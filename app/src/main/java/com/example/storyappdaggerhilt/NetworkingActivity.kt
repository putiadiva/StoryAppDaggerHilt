package com.example.storyappdaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.storyappdaggerhilt.databinding.ActivityNetworkingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NetworkingActivity : AppCompatActivity() {

    private val viewModel: NetworkingViewModel by viewModels()
    private lateinit var binding: ActivityNetworkingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSetToken = binding.btnSetToken
        btnSetToken.setOnClickListener {
            viewModel.login()
        }
    }
}