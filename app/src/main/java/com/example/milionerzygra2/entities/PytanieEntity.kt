package com.example.milionerzygra2.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "pytania",
    indices = [Index(name = "index_poziomTrudnosciId", value = ["poziomTrudnosciId"])],
    foreignKeys = [
        ForeignKey(
            entity = PoziomTrudnosciEntity::class,
            parentColumns = ["id"],
            childColumns = ["poziomTrudnosciId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PytanieEntity(
    @PrimaryKey val id: Int,
    val tresc: String,
    val odpATresc: String,
    val odpBTresc: String,
    val odpCTresc: String,
    val odpDTresc: String,
    val poprawna: Char,
    val poziomTrudnosciId: Int
)