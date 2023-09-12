package com.example.milionerzygra2.models

data class PytanieModel(
    val id: Int,
    val tresc: String,
    val odpATresc: String,
    val odpBTresc: String,
    val odpCTresc: String,
    val odpDTresc: String,
    val poprawna: OdpEnum, // Zakładam, że poprawna odpowiedź jest oznaczona literą 'A', 'B', 'C' lub 'D'
    val poziom: PoziomTrudnosciEnum
)