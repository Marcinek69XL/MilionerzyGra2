package com.example.milionerzygra2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wyniki")
class WynikEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val kwotaWygrana : Int,
    val nazwaUzytkownika: String
)

