package com.example.milionerzygra2.uicontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.milionerzygra2.MyDatabase
import com.example.milionerzygra2.R
import com.example.milionerzygra2.databinding.ActivityNazwaUzytkownikaBinding
import com.example.milionerzygra2.databinding.ActivityZakladkaPytaniaBinding

class ZakladkaPytaniaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakladkaPytaniaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakladkaPytaniaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        val instance = MyDatabase.getDatabase(this.applicationContext);
        val x = instance.pytanieDao().getAllPytania();

        x.forEach { liczba ->
            println(liczba.tresc)
        }
    }

    fun btnOdpC_Clicked(view: View) {

    }
    fun btnOdpA_Clicked(view: View) {}
    fun btnOdpB_Clicked(view: View) {}
    fun btnOdpD_Clicked(view: View) {}
}