package com.example.milionerzygra2.uicontrollers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.R
import com.example.milionerzygra2.databinding.ActivityDobraOdpowiedzBinding
import com.example.milionerzygra2.databinding.ActivityNazwaUzytkownikaBinding
import com.example.milionerzygra2.databinding.ActivityZlaOdpowiedzBinding

class ZlaOdpowiedzActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZlaOdpowiedzBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityZlaOdpowiedzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var wynik = Gra.KoniecGryDajWygranaIZerujGre();
        binding.textWygrana.text = "Wygrałeś: $wynik zł";
    }

    fun btnNowaGraClicked(view: View) {
        val intent = Intent(this, ZakladkaPytaniaActivity::class.java)
        startActivity(intent);
    }

    fun btnOknoMenuClicked(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent);
    }

    override fun onBackPressed() {}
}