package com.example.milionerzygra2.uicontrollers

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.example.milionerzygra2.Gra
import com.example.milionerzygra2.R
import com.example.milionerzygra2.controllers.KoloRatunkoweController
import com.example.milionerzygra2.controllers.PytanieController
import com.example.milionerzygra2.controllers.WynikController
import com.example.milionerzygra2.databinding.ActivityZakladkaPytaniaBinding
import com.example.milionerzygra2.models.OdpEnum
import com.example.milionerzygra2.models.PoziomTrudnosciEnum
import com.example.milionerzygra2.models.PytanieModel
import com.example.milionerzygra2.models.WynikModel
import kotlinx.coroutines.launch

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
        val czyPierwszePytanie = Gra.CzyToPierwszePytanie();

        if (Gra.PokazAktualnaKwoteEtapu() <= 5000){
            pytanie = PytanieController(this.applicationContext, czyPierwszePytanie).DajPytanie(PoziomTrudnosciEnum.LATWE);
        }
        else if (Gra.PokazAktualnaKwoteEtapu() <= 40000)
        {
            pytanie = PytanieController(this.applicationContext, czyPierwszePytanie).DajPytanie(PoziomTrudnosciEnum.SREDNIE);
        }
        else
        {
            pytanie = PytanieController(this.applicationContext, czyPierwszePytanie).DajPytanie(PoziomTrudnosciEnum.TRUDNE);
        }


        zaladujPytanieDoKontrolek(pytanie)
    }

    private fun zaladujPytanieDoKontrolek(pytanie: PytanieModel) {
        binding.textPytanie.text = pytanie.tresc;

        binding.btnOdpA.text = "A." + pytanie.odpATresc;
        binding.btnOdpB.text = "B." + pytanie.odpBTresc;
        binding.btnOdpC.text = "C." + pytanie.odpCTresc;
        binding.btnOdpD.text = "D." + pytanie.odpDTresc;

        if (!Gra.CzyMamPolNaPolDoUzycia())
        {
            binding.half.visibility = INVISIBLE;
        }
        if (!Gra.CzyMamTelefonDoUzycia())
        {
            binding.telephone.visibility = INVISIBLE;
        }
        if (!Gra.CzyMamPublicznoscDoUzycia())
        {
            binding.people.visibility = INVISIBLE;
        }
    }

    fun btnOdpC_Clicked(view: View) {
        if (pytanie.poprawna.equals(OdpEnum.C))
        {
            poprawnaOdpowiedz()
        }
        else
        {
            niepoprawnaOdpowiedz()
        }
    }
    fun btnOdpA_Clicked(view: View) {
        if (pytanie.poprawna.equals(OdpEnum.A))
        {
            poprawnaOdpowiedz()
        }
        else
        {
            niepoprawnaOdpowiedz()
        }
    }
    fun btnOdpB_Clicked(view: View) {
        if (pytanie.poprawna.equals(OdpEnum.B))
        {
            poprawnaOdpowiedz()
        }
        else
        {
            niepoprawnaOdpowiedz()
        }
    }
    fun btnOdpD_Clicked(view: View) {
        if (pytanie.poprawna.equals(OdpEnum.D))
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
            val kwota = Gra.KoniecGryPrzezPoddanieDajWygranaIZerujGre();
            val wynikModel = WynikModel(kwota, Gra.DajNazweGracza())
            lifecycleScope.launch {
                WynikController(this@ZakladkaPytaniaActivity).ZapiszWynik(wynikModel)
            }

            finish() // Zakończ aktywność

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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
            binding.telephone.visibility = INVISIBLE;

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
    fun peopleClicked(view: View) {
        if (Gra.CzyMamPublicznoscDoUzycia())
        {
            Gra.OznaczPublicznoscJakoUzyty();
            binding.people.visibility = INVISIBLE;


            // Tworzenie i wyświetlanie dialogu
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.telefon_od_przyjaciela) // uzyjemy ten sam

            // Pobieranie referencji do widoków w dialogu
            val textViewQuestion = dialog.findViewById<TextView>(R.id.textViewQuestionFromFriend)
            val textViewAnswer = dialog.findViewById<TextView>(R.id.textViewAnswerFromFriend)
            val buttonClose = dialog.findViewById<Button>(R.id.buttonCloseDialog)

            // Losowanie odpowiedzi od przyjaciela
            val glosowanieModel = ratunkoweController.GenerujGlosowaniePublicznosci(pytanie.poprawna, pytanie.poziom);

            // Ustawienie treści dialogu
            textViewQuestion.text = "Głosowanie publiczności:"
            textViewAnswer.text = "${pytanie.odpATresc}: ${glosowanieModel.A} ${System.lineSeparator()}" +
                    "${pytanie.odpBTresc}: ${glosowanieModel.B} ${System.lineSeparator()}" +
                    "${pytanie.odpCTresc}: ${glosowanieModel.C} ${System.lineSeparator()}" +
                    "${pytanie.odpDTresc}: ${glosowanieModel.D} ${System.lineSeparator()}";

            // Obsługa zamknięcia dialogu
            buttonClose.setOnClickListener {
                dialog.dismiss() // Zamknięcie dialogu po naciśnięciu przycisku
            }

            // Wyświetlenie dialogu
            dialog.show()
        }
    }
    fun halfClicked(view: View) {
        if (Gra.CzyMamPolNaPolDoUzycia()){
            Gra.OznaczPolNaPolJakoUzyty();
            binding.half.visibility = INVISIBLE;

            var poprawna = pytanie.poprawna;

            // Tworzenie listy odpowiedzi z wyłączeniem poprawnej odpowiedzi
            val dostepneOdpowiedzi = mutableListOf(OdpEnum.A, OdpEnum.B, OdpEnum.C, OdpEnum.D)

            dostepneOdpowiedzi.remove(poprawna)

            // Losowanie dwóch pozostałych odpowiedzi
            val losoweOdpowiedzi = dostepneOdpowiedzi.shuffled().take(2)

            // Zmiana koloru odpowiedzi na losowe
            when (losoweOdpowiedzi[0]) {
                OdpEnum.A -> zmienKolorOdpowiedzi(OdpEnum.A)
                OdpEnum.B -> zmienKolorOdpowiedzi(OdpEnum.B)
                OdpEnum.C -> zmienKolorOdpowiedzi(OdpEnum.C)
                OdpEnum.D -> zmienKolorOdpowiedzi(OdpEnum.D)
            }

            when (losoweOdpowiedzi[1]) {
                OdpEnum.A -> zmienKolorOdpowiedzi(OdpEnum.A)
                OdpEnum.B -> zmienKolorOdpowiedzi(OdpEnum.B)
                OdpEnum.C -> zmienKolorOdpowiedzi(OdpEnum.C)
                OdpEnum.D -> zmienKolorOdpowiedzi(OdpEnum.D)
            }
        }
    }

    private fun zmienKolorOdpowiedzi(odpEnum: OdpEnum) {
        var kolor = Color.RED;

        when (odpEnum) {
            OdpEnum.A -> {
                binding.btnOdpA.setTextColor(kolor)
                binding.btnOdpA.isClickable = false;
            }
            OdpEnum.B -> {
                binding.btnOdpB.setTextColor(kolor)
                binding.btnOdpB.isClickable = false;
            }
            OdpEnum.C -> {
                binding.btnOdpC.setTextColor(kolor)
                binding.btnOdpC.isClickable = false;
            }
            OdpEnum.D -> {
                binding.btnOdpD.setTextColor(kolor)
                binding.btnOdpD.isClickable = false;
            }
        }
    }
}