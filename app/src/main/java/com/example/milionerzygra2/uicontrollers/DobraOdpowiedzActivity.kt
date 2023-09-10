package com.example.milionerzygra2.uicontrollers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.R
import com.example.milionerzygra2.databinding.ActivityDobraOdpowiedzBinding
import com.example.milionerzygra2.databinding.ActivityMainBinding

class DobraOdpowiedzActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDobraOdpowiedzBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDobraOdpowiedzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ustawKontrolki();
    }

    private fun ustawKontrolki() {
        val wygranaAktualna = Gra.PokazAktualnaKwoteEtapu();
        val nastepnaWybrana = Gra.PokazKwoteNastepnegoPytania();

        if(nastepnaWybrana == null){
            // TODO: Koniec gry, wygrales mln, nowa activity
        }

        binding.textViewCurrentWin.text = "Wygrałeś: " + wygranaAktualna;
        binding.textViewNextWin.text = "Następne pytanie o: " + nastepnaWybrana;
    }

    fun btnContinueClicked(view: View) {
        val intent = Intent(this, ZakladkaPytaniaActivity::class.java)
        startActivity(intent);
    }

    override fun onBackPressed() {}
}