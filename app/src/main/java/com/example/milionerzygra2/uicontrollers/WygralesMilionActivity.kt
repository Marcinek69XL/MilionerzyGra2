package com.example.milionerzygra2.uicontrollers

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.R
import com.example.milionerzygra2.controllers.WynikController
import com.example.milionerzygra2.databinding.ActivityNazwaUzytkownikaBinding
import com.example.milionerzygra2.databinding.ActivityWygralesMilionBinding
import com.example.milionerzygra2.models.EtapyKwotyEnum
import com.example.milionerzygra2.models.WynikModel
import kotlinx.coroutines.launch

class WygralesMilionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWygralesMilionBinding
    private var czyJuzZapisano = false;
    private lateinit var wynikController : WynikController;
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWygralesMilionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Piosenka
        mediaPlayer = MediaPlayer.create(this, R.raw.we_are_the_champions);
        mediaPlayer?.start()

        wynikController = WynikController(this);

        ZaladujDoUI(Gra.DajNazweGracza());
    }

    private fun ZaladujDoUI(gracz: String)
    {
        binding.tvGratulacje.text = "Gratulacje $gracz";
    }

    fun btnZacznijOdNowaClicked(view: View) {
        Gra.KoniecGryDajWygranaIZerujGre(this); // zeby wyzerowac, nie tworze specjalnie nwoej

        val intent = Intent(this, ZakladkaPytaniaActivity::class.java)
        startActivity(intent);
    }
    fun btnWrocDoEkranuStartowegoClicked(view: View) {
        Gra.KoniecGryDajWygranaIZerujGre(this); // zeby wyzerowac, nie tworze specjalnie nwoej

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent);
    }
    fun btnZapiszRezultatClicked(view: View) {

        if (!czyJuzZapisano)
        {
            val wynikModel = WynikModel(EtapyKwotyEnum._1000000.kwota, Gra.DajNazweGracza());

            lifecycleScope.launch {
                wynikController.ZapiszWynik(wynikModel);
            }

            czyJuzZapisano = true;
            Toast.makeText(this, "Zapisano", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Wynik już zapisano raz", Toast.LENGTH_SHORT).show();
        }
    }
    override fun onBackPressed() {}

    override fun onDestroy() {
        super.onDestroy()

        // Zwolnienie zasobów MediaPlayer po zakończeniu aktywności
        mediaPlayer?.release()
        mediaPlayer = null
    }
}