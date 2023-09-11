package com.example.milionerzygra2.controllers

import com.example.milionerzygra2.models.PoziomTrudnosciEnum
import com.example.milionerzygra2.models.PytanieModel
import kotlin.random.Random

class KoloRatunkoweController {

    var NIE_WIEM = "Hm... powiem szczerze, nie mam pojęcia, nie mogę Ci pomóc."
    var PEWNOSC = "Jestem pewny że jest to odpowiedź <ODP>"
    var RACZEJ = "Hm... coś podpowiada mi intuicja że może to być <ODP>, ale nie wiem na 100%"

    public fun DajOdpowiedzPrzyjaciela(pytanie: PytanieModel) : String
    {
        var str = DajTypOdpowiedzi(pytanie.poziom)

        if (str == NIE_WIEM)
        {
            return str;
        }

        return WklejOdpowiedzDoTypuOdpowiedzi(str, pytanie);
    }

    private fun DajTypOdpowiedzi(poziom: PoziomTrudnosciEnum) : String
    {
        if (poziom == PoziomTrudnosciEnum.LATWE)
        {
            val losowaLiczba = Random.nextInt(101) // Generowanie losowej liczby od 0 do 100 (włącznie)

            if(losowaLiczba <= 85){
                return PEWNOSC;
            }
            if(losowaLiczba == 101)
            {
                return NIE_WIEM;
            }

            return RACZEJ;
        }
        if (poziom == PoziomTrudnosciEnum.SREDNIE)
        {
            val losowaLiczba = Random.nextInt(101) // Generowanie losowej liczby od 0 do 100 (włącznie)

            if(losowaLiczba <= 50){
                return PEWNOSC;
            }
            if(losowaLiczba <= 70)
            {
                return NIE_WIEM;
            }

            return RACZEJ;
        }
        if (poziom == PoziomTrudnosciEnum.TRUDNE)
        {
            val losowaLiczba = Random.nextInt(101) // Generowanie losowej liczby od 0 do 100 (włącznie)

            if(losowaLiczba <= 25){
                return PEWNOSC;
            }
            if(losowaLiczba <= 70)
            {
                return NIE_WIEM;
            }

            return RACZEJ;
        }
        throw NotImplementedError();
    }

    private fun WklejOdpowiedzDoTypuOdpowiedzi(str : String, pytanie: PytanieModel) : String
    {
        val losowaLiczba1 = Random.nextInt(101)
        val losowaLiczba2 = Random.nextInt(101)

        if (str == PEWNOSC){
            if (losowaLiczba1 < 100){
                var odp = pytanie.poprawna.name;
                if (odp == "A"){
                    return str.replace("<ODP>", pytanie.odpATresc)
                }
                if (odp == "B"){
                    return str.replace("<ODP>", pytanie.odpBTresc)
                }
                if (odp == "C"){
                    return str.replace("<ODP>", pytanie.odpCTresc)
                }
                if (odp == "D"){
                    return str.replace("<ODP>", pytanie.odpDTresc)
                }
                throw Exception()
            }
            else
            {
                if (losowaLiczba2 <= 25)
                {
                    return str.replace("<ODP>", pytanie.odpATresc);
                }
                if (losowaLiczba2 <= 50)
                {
                    return str.replace("<ODP>", pytanie.odpBTresc);
                }
                if (losowaLiczba2 <= 75)
                {
                    return str.replace("<ODP>", pytanie.odpCTresc);
                }

                return str.replace("<ODP>", pytanie.odpDTresc);
            }
        }

        if (str == RACZEJ){
            if (losowaLiczba1 < 70){
                var odp = pytanie.poprawna.name;
                return str.replace("<ODP>", odp)
            }
            else
            {
                if (losowaLiczba2 <= 25)
                {
                    return str.replace("<ODP>", pytanie.odpATresc);
                }
                if (losowaLiczba2 <= 50)
                {
                    return str.replace("<ODP>", pytanie.odpBTresc);
                }
                if (losowaLiczba2 <= 75)
                {
                    return str.replace("<ODP>", pytanie.odpCTresc);
                }

                return str.replace("<ODP>", pytanie.odpDTresc);
            }
        }

        if (str == NIE_WIEM)
        {
            return str;
        }

        return NIE_WIEM;
    }
}