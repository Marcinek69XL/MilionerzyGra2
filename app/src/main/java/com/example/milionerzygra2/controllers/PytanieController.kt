package com.example.milionerzygra2.controllers

import android.content.Context
import com.example.milionerzygra2.MyDatabase
import com.example.milionerzygra2.entities.PoziomTrudnosciEntity
import com.example.milionerzygra2.entities.PytanieEntity
import com.example.milionerzygra2.models.OdpEnum
import com.example.milionerzygra2.models.PoziomTrudnosciEnum
import com.example.milionerzygra2.models.PytanieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

class PytanieController {

    companion object
    {
        private lateinit var _dostepnePytaniaLatwe : MutableList<PytanieModel>;
        private lateinit var _dostepnePytaniaSrednie : MutableList<PytanieModel>;
        private lateinit var _dostepnePytaniaTrudne : MutableList<PytanieModel>;

    }


    //TODO: DALEJ COS NIE TAK, DALEJ MAM DUBLIKATY PYTAN
    constructor(applicationContext: Context, resetPytan: Boolean){
        if(!resetPytan)
        {
            return ;
        }
        _dostepnePytaniaLatwe = mutableListOf()
        _dostepnePytaniaSrednie = mutableListOf()
        _dostepnePytaniaTrudne = mutableListOf()

        runBlocking {
            launch(Dispatchers.IO) {
                val instance = MyDatabase.getDatabase(applicationContext);
                val pytaniaEntities = instance.pytanieDao().getAllPytania();
                val poziomyEntities = instance.poziomTrudnosciDao().getAllPoziomyTrunosci();

                for (pytanieEnt in pytaniaEntities){
                    var model = mapPytanieEntityToModel(pytanieEnt, poziomyEntities);
                    if(model.poziom == PoziomTrudnosciEnum.LATWE){
                        _dostepnePytaniaLatwe.add(model);
                    }
                    if(model.poziom == PoziomTrudnosciEnum.SREDNIE){
                        _dostepnePytaniaSrednie.add(model);
                    }
                    if(model.poziom == PoziomTrudnosciEnum.TRUDNE){
                        _dostepnePytaniaTrudne.add(model);
                    }
                }
            }
        }
    }
    fun DajPytanie(poziom: PoziomTrudnosciEnum): PytanieModel
    {
        if (poziom == PoziomTrudnosciEnum.LATWE){
            val randomIndex = (0 until _dostepnePytaniaLatwe.size).random()
            var pytanieRemoved =  _dostepnePytaniaLatwe.removeAt(randomIndex);
            return pytanieRemoved;
        }
        if (poziom == PoziomTrudnosciEnum.SREDNIE){
            val randomIndex = (0 until _dostepnePytaniaSrednie.size).random()
            return _dostepnePytaniaSrednie.removeAt(randomIndex);
        }
        if (poziom == PoziomTrudnosciEnum.TRUDNE){
            val randomIndex = (0 until _dostepnePytaniaTrudne.size).random()
            return _dostepnePytaniaTrudne.removeAt(randomIndex);
        }
        else
        {
            throw IllegalArgumentException();
        }
    }

    private fun mapPytanieEntityToModel(entity: PytanieEntity, poziomy: List<PoziomTrudnosciEntity>): PytanieModel {
        var poziom = poziomy.find { it.id == entity.poziomTrudnosciId }!!;

        return PytanieModel(
            id = entity.id,
            tresc = entity.tresc,
            odpATresc = entity.odpATresc,
            odpBTresc = entity.odpBTresc,
            odpCTresc = entity.odpCTresc,
            odpDTresc = entity.odpDTresc,
            poprawna = mapPoprawnaEntityToModel(entity.poprawna),
            poziom = mapPoziomEntityToModel(poziom)
        );
    }

    private fun mapPoziomEntityToModel(poziom: PoziomTrudnosciEntity) : PoziomTrudnosciEnum
    {
        if(poziom.poziomTrudnosci == "latwe")
            return PoziomTrudnosciEnum.LATWE
        if(poziom.poziomTrudnosci == "srednie")
            return PoziomTrudnosciEnum.SREDNIE
        if(poziom.poziomTrudnosci == "trudne")
            return PoziomTrudnosciEnum.TRUDNE
        
        throw Exception("mapPoziomEntityToModel failed");
    }

    private fun mapPoprawnaEntityToModel(poprawna: Char) : OdpEnum
    {
        if(poprawna == 'A')
            return OdpEnum.A;
        if(poprawna == 'B')
            return OdpEnum.B;
        if(poprawna == 'C')
            return OdpEnum.C;
        if(poprawna == 'D')
            return OdpEnum.D;

        throw Exception("mapPoprawnaEntityToModel failed");
    }
}