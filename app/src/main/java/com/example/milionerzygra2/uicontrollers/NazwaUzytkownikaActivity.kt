package com.example.milionerzygra2.uicontrollers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.R
import com.example.milionerzygra2.databinding.ActivityMainBinding
import com.example.milionerzygra2.databinding.ActivityNazwaUzytkownikaBinding
import com.example.milionerzygra2.databinding.ActivityZakladkaPytaniaBinding

class NazwaUzytkownikaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNazwaUzytkownikaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNazwaUzytkownikaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startGameClicked(view: View) {
        val nazwaUzyt = binding.usernameEditText.text.toString();
        Gra.ZacznijGre(nazwaUzyt, this);

        val intent = Intent(this, ZakladkaPytaniaActivity::class.java)
        startActivity(intent);
    }
}