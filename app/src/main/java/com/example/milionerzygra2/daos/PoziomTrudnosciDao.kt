package com.example.milionerzygra2.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.milionerzygra2.entities.PoziomTrudnosciEntity

@Dao
interface PoziomTrudnosciDao {
    @Insert
    fun insert(poziomTrudnosci: PoziomTrudnosciEntity)

    @Query("SELECT * FROM poziomy_trudnosci")
    fun getAllPoziomyTrunosci(): List<PoziomTrudnosciEntity>

    @Insert
    fun insertAll(poziomy: List<PoziomTrudnosciEntity>)
}