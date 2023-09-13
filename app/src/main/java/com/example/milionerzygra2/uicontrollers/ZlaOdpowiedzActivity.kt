package com.example.milionerzygra2.uicontrollers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.controllers.WynikController
import com.example.milionerzygra2.databinding.ActivityZlaOdpowiedzBinding
import com.example.milionerzygra2.models.WynikModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ZlaOdpowiedzActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityZlaOdpowiedzBinding
    private lateinit var _wynik : WynikModel
    private lateinit var _wynikController: WynikController;
    private var _czyZapisanoJuz : Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityZlaOdpowiedzBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _wynikController = WynikController(this);

        var nazwaGracza = Gra.DajNazweGracza();
        var wynikKwota = Gra.KoniecGryDajWygranaIZerujGre(this);

        _wynik = WynikModel(wynikKwota, nazwaGracza);

        _binding.textWygrana.text = "Wygrałeś: ${_wynik.kwotaWygrana} zł";
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
    fun btnSaveScoreClicked(view: View) {
        if (_czyZapisanoJuz) {
            Toast.makeText(this, "Wynik już raz zapisano!", Toast.LENGTH_SHORT).show()
        } else {
            _czyZapisanoJuz = true;
            lifecycleScope.launch {
                _wynikController.ZapiszWynik(_wynik)
                Toast.makeText(this@ZlaOdpowiedzActivity, "Zapisano", Toast.LENGTH_SHORT).show()
            }
        }
    }
}