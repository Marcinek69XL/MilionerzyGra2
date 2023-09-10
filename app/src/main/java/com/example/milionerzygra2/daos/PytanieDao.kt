package com.example.milionerzygra2.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.milionerzygra2.entities.PytanieEntity

@Dao
interface PytanieDao {
    @Insert
    fun insert(pytanie: PytanieEntity)

    @Query("SELECT * FROM pytania")
    fun getAllPytania(): List<PytanieEntity>

    @Insert
    fun insertAll(pytania: List<PytanieEntity>)

    @Query("SELECT * FROM pytania WHERE id = :pytanieId")
    fun getPytanieById(pytanieId: Int): PytanieEntity
}