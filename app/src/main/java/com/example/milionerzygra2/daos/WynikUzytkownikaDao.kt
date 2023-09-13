package com.example.milionerzygra2.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.milionerzygra2.entities.PytanieEntity
import com.example.milionerzygra2.entities.WynikEntity

@Dao
interface WynikUzytkownikaDao {
    @Insert
    fun insert(wynikEntity: WynikEntity)

    @Query("SELECT * FROM wyniki")
    fun getAllWyniki(): List<WynikEntity>
}