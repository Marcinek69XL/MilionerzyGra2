package com.example.milionerzygra2.seeders

import com.example.milionerzygra2.entities.PoziomTrudnosciEntity

class PoziomTrudnosciSeeder {
    fun getPoziomyTrudnosci(): List<PoziomTrudnosciEntity> {
        // Tutaj możesz zwrócić przykładowe poziomy trudności
        return listOf(
            PoziomTrudnosciEntity(1, "latwe"),
            PoziomTrudnosciEntity(2, "srednie"),
            PoziomTrudnosciEntity(3, "trudne")
        )
    }
}