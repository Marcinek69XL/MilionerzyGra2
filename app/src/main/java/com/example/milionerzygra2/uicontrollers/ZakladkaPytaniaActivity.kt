package com.example.milionerzygra2.uicontrollers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.Gra.Companion.PrzejdzDoNastepnegoEtapu
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
        if (pytanie.poprawna.equals(PoprawnaOdpEnum.C))
        {
            poprawnaOdpowiedz()
        }
        else
        {
            niepoprawnaOdpowiedz()
        }
    }
    fun btnOdpA_Clicked(view: View) {
        if (pytanie.poprawna.equals(PoprawnaOdpEnum.A))
        {
            poprawnaOdpowiedz()
        }
        else
        {
            niepoprawnaOdpowiedz()
        }
    }
    fun btnOdpB_Clicked(view: View) {
        if (pytanie.poprawna.equals(PoprawnaOdpEnum.B))
        {
            poprawnaOdpowiedz()
        }
        else
        {
            niepoprawnaOdpowiedz()
        }
    }
    fun btnOdpD_Clicked(view: View) {
        if (pytanie.poprawna.equals(PoprawnaOdpEnum.D))
        {
            poprawnaOdpowiedz()
        }
        else
        {
            niepoprawnaOdpowiedz()
        }
    }

    private fun poprawnaOdpowiedz()
    {
        Gra.PrzejdzDoNastepnegoEtapu();

        val intent = Intent(this, DobraOdpowiedzActivity::class.java)
        startActivity(intent);
    }

    private fun niepoprawnaOdpowiedz()
    {
        val intent = Intent(this, ZlaOdpowiedzActivity::class.java)
        startActivity(intent);
    }

    override fun onBackPressed()
    {
        showExitConfirmationDialog();
    }

    private fun showExitConfirmationDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)

        // Ustaw tytuł komunikatu
        alertDialogBuilder.setTitle("Czy zakończyć grę i zapisać wynik?")

        // Ustaw treść komunikatu
        alertDialogBuilder.setMessage("Czy na pewno chcesz zakończyć grę i zapisać wynik?")

        // Dodaj przycisk "Zapisz i zakończ"
        alertDialogBuilder.setPositiveButton("Zapisz i zakończ") { _, _ ->
            // Tutaj umieść kod do zapisania wyniku
            finish() // Zakończ aktywność
        }

        // Dodaj przycisk "Zakończ"
        alertDialogBuilder.setNegativeButton("Zakończ") { _, _ ->
            finish() // Zakończ aktywność bez zapisywania wyniku
        }

        // Dodaj przycisk "Anuluj"
        alertDialogBuilder.setNeutralButton("Anuluj") { dialog, _ ->
            dialog.dismiss() // Anuluj zamknięcie komunikatu
        }

        // Utwórz i pokaż komunikat
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}