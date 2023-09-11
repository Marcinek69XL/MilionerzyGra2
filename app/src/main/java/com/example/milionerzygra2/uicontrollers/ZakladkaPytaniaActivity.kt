package com.example.milionerzygra2.uicontrollers

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.Gra.Companion.PrzejdzDoNastepnegoEtapu
import com.example.milionerzygra2.R
import com.example.milionerzygra2.controllers.KoloRatunkoweController
import com.example.milionerzygra2.controllers.PytanieController
import com.example.milionerzygra2.databinding.ActivityZakladkaPytaniaBinding
import com.example.milionerzygra2.models.PoprawnaOdpEnum
import com.example.milionerzygra2.models.PoziomTrudnosciEnum
import com.example.milionerzygra2.models.PytanieModel

class ZakladkaPytaniaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakladkaPytaniaBinding
    private lateinit var pytanie: PytanieModel;
    private lateinit var ratunkoweController: KoloRatunkoweController;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakladkaPytaniaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        ratunkoweController = KoloRatunkoweController();

        if (Gra.PokazAktualnaKwoteEtapu() <= 5000){
            pytanie = PytanieController(this.applicationContext).DajPytanie(PoziomTrudnosciEnum.LATWE);
        }
        if (Gra.PokazAktualnaKwoteEtapu() <= 40000)
        {
            pytanie = PytanieController(this.applicationContext).DajPytanie(PoziomTrudnosciEnum.SREDNIE);
        }
        else
        {
            pytanie = PytanieController(this.applicationContext).DajPytanie(PoziomTrudnosciEnum.TRUDNE);
        }


        zaladujPytanieDoKontrolek(pytanie)
    }

    private fun zaladujPytanieDoKontrolek(pytanie: PytanieModel) {
        binding.textPytanie.text = pytanie.tresc;

        binding.btnOdpA.text = pytanie.odpATresc;
        binding.btnOdpB.text = pytanie.odpBTresc;
        binding.btnOdpC.text = pytanie.odpCTresc;
        binding.btnOdpD.text = pytanie.odpDTresc;

        if (!Gra.CzyMamPolNaPolDoUzycia())
        {
            binding.half.visibility = GONE;
        }
        if (!Gra.CzyMamTelefonDoUzycia())
        {
            binding.telephone.visibility = GONE;
        }
        if (!Gra.CzyMamPublicznoscDoUzycia())
        {
            binding.people.visibility = GONE;
        }
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

    fun telephoneClicked(view: View) {
        if (Gra.CzyMamTelefonDoUzycia()) {
            Gra.OznaczTelefonJakoUzyty();

            // Tworzenie i wyświetlanie dialogu
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.telefon_od_przyjaciela)

            // Pobieranie referencji do widoków w dialogu
            val textViewQuestion = dialog.findViewById<TextView>(R.id.textViewQuestionFromFriend)
            val textViewAnswer = dialog.findViewById<TextView>(R.id.textViewAnswerFromFriend)
            val buttonClose = dialog.findViewById<Button>(R.id.buttonCloseDialog)

            // Losowanie odpowiedzi od przyjaciela
            val odpowiedzPrzyjaciela = ratunkoweController.DajOdpowiedzPrzyjaciela(pytanie);

            // Ustawienie treści dialogu
            textViewQuestion.text = "Przyjaciel mówi:"
            textViewAnswer.text = odpowiedzPrzyjaciela

            // Obsługa zamknięcia dialogu
            buttonClose.setOnClickListener {
                dialog.dismiss() // Zamknięcie dialogu po naciśnięciu przycisku
            }

            // Wyświetlenie dialogu
            dialog.show()
        }
    }
    fun peopleClicked(view: View) {}
    fun halfClicked(view: View) {}
}