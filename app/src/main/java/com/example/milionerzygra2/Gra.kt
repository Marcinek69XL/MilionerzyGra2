package com.example.milionerzygra2

import android.content.Context
import com.example.milionerzygra2.controllers.PytanieController
import com.example.milionerzygra2.models.EtapyKwotyEnum
import com.example.milionerzygra2.models.PoziomTrudnosciEnum
import com.example.milionerzygra2.models.PytanieModel
import java.lang.Exception

public class Gra
{
    companion object {
        private var _etapGryKwota = EtapyKwotyEnum._0;
        private var _nazwaUzytkownika = "";
        private var _dostepnyTelefon = true;
        private var _dostepnaPublicznosc = true;
        private var _dostepnePolNaPol = true;
        private lateinit var _pytanieController : PytanieController;


        public fun KoniecGryDajWygranaIZerujGre(context: Context) : Int
        {
            var kwotaWygrana = 0;
            if (_etapGryKwota == EtapyKwotyEnum._1000000){
                kwotaWygrana = EtapyKwotyEnum._1000000.kwota;
            }
            else if (_etapGryKwota.kwota >= EtapyKwotyEnum._40000.kwota){
                kwotaWygrana = EtapyKwotyEnum._40000.kwota;
            }
            else if (_etapGryKwota.kwota >= EtapyKwotyEnum._1000.kwota){
                kwotaWygrana = EtapyKwotyEnum._1000.kwota;
            }

            zerujGreZostawUzytkownika(context)

            return kwotaWygrana;
        }

        public fun KoniecGryPrzezPoddanieDajWygranaIZerujGre(context: Context) : Int
        {
            var kwota = _etapGryKwota.kwota;
            zerujGreZostawUzytkownika(context);
            return kwota;
        }

        public fun PokazAktualnaKwoteEtapu() : Int
        {
            return _etapGryKwota.kwota
        }

        /**
         * @return Jesli nie ma nic dalej, czyli aktualnie milion, to null
         */
        public fun PokazKwoteNastepnegoPytania() : Int?
        {
            val values = EtapyKwotyEnum.values()
            val index = values.indexOf(_etapGryKwota)

            try{
                return values[index + 1].kwota;
            }
            catch (e: Exception){
                return null;
            }
        }
        public fun ZacznijGre(nazwaUzyt: String, context: Context)
        {
            _pytanieController = PytanieController(context)

            _nazwaUzytkownika = nazwaUzyt;
            zerujGreZostawUzytkownika(context)
        }

        fun DajPytanie(context: Context): PytanieModel
        {
            if (Gra.PokazAktualnaKwoteEtapu() <= 5000)
            {
                return _pytanieController.DajPytanie(PoziomTrudnosciEnum.LATWE);
            }
            else if (Gra.PokazAktualnaKwoteEtapu() <= 40000)
            {
                return _pytanieController.DajPytanie(PoziomTrudnosciEnum.SREDNIE);
            }
            else
            {
                return _pytanieController.DajPytanie(PoziomTrudnosciEnum.TRUDNE);
            }
        }

        private fun zerujGreZostawUzytkownika(context: Context)
        {
            _etapGryKwota = EtapyKwotyEnum._0;
            _dostepnyTelefon = true;
            _dostepnePolNaPol = true;
            _dostepnaPublicznosc = true;

            _pytanieController = PytanieController(context);
        }

        public fun PrzejdzDoNastepnegoEtapu() {
            val values = EtapyKwotyEnum.values()
            val index = values.indexOf(_etapGryKwota)
            _etapGryKwota = values[index + 1];
        }

        public fun CzyMamTelefonDoUzycia() : Boolean
        {
            return _dostepnyTelefon;
        }

        public fun CzyMamPublicznoscDoUzycia() : Boolean
        {
            return _dostepnaPublicznosc;
        }

        public fun CzyMamPolNaPolDoUzycia() : Boolean
        {
            return _dostepnePolNaPol;
        }

        public fun OznaczTelefonJakoUzyty()
        {
            _dostepnyTelefon = false;
        }
        public fun OznaczPublicznoscJakoUzyty()
        {
            _dostepnaPublicznosc = false;
        }
        public fun OznaczPolNaPolJakoUzyty()
        {
            _dostepnePolNaPol = false;
        }

        fun CzyToPierwszePytanie(): Boolean {
            return _etapGryKwota == EtapyKwotyEnum._0;
        }

        public fun DajNazweGracza() : String
        {
            return _nazwaUzytkownika;
        }
    }
}