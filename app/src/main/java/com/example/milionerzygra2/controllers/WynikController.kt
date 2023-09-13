package com.example.milionerzygra2.controllers

import android.content.Context
import com.example.milionerzygra2.MyDatabase
import com.example.milionerzygra2.entities.WynikEntity
import com.example.milionerzygra2.models.WynikModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class WynikController
{
    lateinit var _context : Context;
    constructor(context: Context)
    {
        _context = context;
    }


    suspend fun ZapiszWynik(wynik: WynikModel)
    {
        return withContext(Dispatchers.IO)
        {
            var entity = MapToEntity(wynik);

            MyDatabase.getDatabase(_context).wynikUzytkownikaDao().insert(entity);
        }

    }

    suspend fun DajWszystkieWynikiPosortowaneByWynikDesc(): List<WynikModel> {
        return withContext(Dispatchers.IO) {
            val wynikiEntities = MyDatabase.getDatabase(_context).wynikUzytkownikaDao().getAllWyniki()
            val wynikiModelsOrdered = wynikiEntities
                .sortedByDescending { it.kwotaWygrana }
                .map { MapToModel(it) }

            wynikiModelsOrdered
        }
    }

    private fun MapToEntity(wynik: WynikModel) : WynikEntity
    {
        return WynikEntity(0, wynik.kwotaWygrana, wynik.nazwaUzytkownika);
    }
    private fun MapToModel(wynik: WynikEntity) : WynikModel
    {
        return WynikModel(wynik.kwotaWygrana, wynik.nazwaUzytkownika);
    }
}