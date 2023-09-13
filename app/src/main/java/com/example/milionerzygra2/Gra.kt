package com.example.milionerzygra2

import com.example.milionerzygra2.models.EtapyKwotyEnum
import java.lang.Exception

public class Gra
{
    companion object {
        private var _etapGryKwota = EtapyKwotyEnum._0;
        private var _nazwaUzytkownika = "";
        private var _dostepnyTelefon = true;
        private var _dostepnaPublicznosc = true;
        private var _dostepnePolNaPol = true;


        public fun KoniecGryDajWygranaIZerujGre() : Int
        {
            var kwotaWygrana = 0;
            if (_etapGryKwota == EtapyKwotyEnum._1000000){
                kwotaWygrana = EtapyKwotyEnum._1000000.kwota;
            }
            if (_etapGryKwota.kwota >= EtapyKwotyEnum._40000.kwota){
                return EtapyKwotyEnum._40000.kwota;
            }
            if (_etapGryKwota.kwota >= EtapyKwotyEnum._1000.kwota){
                return EtapyKwotyEnum._1000.kwota;
            }

            zerujGreZostawUzytkownika()

            return kwotaWygrana;
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
        public fun ZacznijGre(nazwaUzyt: String)
        {
            _nazwaUzytkownika = nazwaUzyt;
            zerujGreZostawUzytkownika()
        }

        private fun zerujGreZostawUzytkownika()
        {
            _etapGryKwota = EtapyKwotyEnum._0;
            _dostepnyTelefon = true;
            _dostepnePolNaPol = true;
            _dostepnaPublicznosc = true;
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