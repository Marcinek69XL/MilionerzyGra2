package com.example.milionerzygra2.uicontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.milionerzygra2.databinding.ActivityMainBinding
import com.example.milionerzygra2.databinding.ActivityZakladkaPytaniaBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}