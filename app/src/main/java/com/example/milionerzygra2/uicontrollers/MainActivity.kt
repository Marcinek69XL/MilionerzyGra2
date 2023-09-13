package com.example.milionerzygra2.uicontrollers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.milionerzygra2.databinding.ActivityMainBinding
import com.example.milionerzygra2.databinding.ActivityZakladkaPytaniaBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun zacznijGreClicked(view: View) {
        val intent = Intent(this, NazwaUzytkownikaActivity::class.java)
        startActivity(intent);
    }

    fun btnWynikiClicked(view: View) {
        val intent = Intent(this, WynikiActivity::class.java)
        startActivity(intent);
    }
}