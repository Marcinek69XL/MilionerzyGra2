package com.example.milionerzygra2.uicontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.milionerzygra2.controllers.PytanieController
import com.example.milionerzygra2.databinding.ActivityZakladkaPytaniaBinding
import com.example.milionerzygra2.models.PoprawnaOdpEnum
import com.example.milionerzygra2.models.PoziomTrudnosciEnum
import com.example.milionerzygra2.models.PytanieModel

class ZakladkaPytaniaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakladkaPytaniaBinding
    private lateinit var pytanie: PytanieModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakladkaPytaniaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        pytanie = PytanieController(this.applicationContext).DajPytanie(PoziomTrudnosciEnum.LATWE);
        zaladujPytanieDoKontrolek(pytanie)
    }

    private fun zaladujPytanieDoKontrolek(pytanie: PytanieModel) {
        binding.textPytanie.text = pytanie.tresc;

        binding.btnOdpA.text = pytanie.odpATresc;
        binding.btnOdpB.text = pytanie.odpBTresc;
        binding.btnOdpC.text = pytanie.odpCTresc;
        binding.btnOdpD.text = pytanie.odpDTresc;
    }

    fun btnOdpC_Clicked(view: View) {
        if (pytanie.poprawna == PoprawnaOdpEnum.C)
        {
            Toast.makeText(this.applicationContext, "sialala", Toast.LENGTH_LONG).show();
        }
    }
    fun btnOdpA_Clicked(view: View) {}
    fun btnOdpB_Clicked(view: View) {}
    fun btnOdpD_Clicked(view: View) {}
}