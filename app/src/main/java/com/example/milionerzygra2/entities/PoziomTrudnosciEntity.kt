package com.example.milionerzygra2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poziomy_trudnosci")
data class PoziomTrudnosciEntity(
    @PrimaryKey val id: Int,
    val poziomTrudnosci: String // Może być "latwe", "srednie", "trudne"
)