package com.example.milionerzygra2.seeders

import com.example.milionerzygra2.entities.PytanieEntity

class PytanieSeeder {
    fun getPrzykladowePytania(): List<PytanieEntity> {
        //val poziomyTrudnosci = PoziomTrudnosciSeeder().getPoziomyTrudnosci() // Pobierz przykładowe poziomy trudności

        return listOf(
            PytanieEntity(
                id = 1,
                tresc = "Jaki jest stolica Francji?",
                odpATresc = "Londyn",
                odpBTresc = "Paryż",
                odpCTresc = "Berlin",
                odpDTresc = "Madryt",
                poprawna = 'B',
                poziomTrudnosciId = 1 // Przypisz poziom trudności
            ),
            PytanieEntity(
                id = 2,
                tresc = "Który pierwiastek chemiczny ma symbol 'H'?",
                odpATresc = "Hel",
                odpBTresc = "Hydrogen",
                odpCTresc = "Hafn",
                odpDTresc = "Hahnium",
                poprawna = 'B',
                poziomTrudnosciId = 3 // Przypisz poziom trudności
            ),
            PytanieEntity(
                id = 3,
                tresc = "Ile wynosi 2 + 2?",
                odpATresc = "1",
                odpBTresc = "3",
                odpCTresc = "4",
                odpDTresc = "5",
                poprawna = 'C',
                poziomTrudnosciId = 1 // Przypisz poziom trudności
            ),
            PytanieEntity(
                id = 4,
                tresc = "Która planeta jest najbliżej Słońca?",
                odpATresc = "Mars",
                odpBTresc = "Jowisz",
                odpCTresc = "Ziemia",
                odpDTresc = "Merkury",
                poprawna = 'D',
                poziomTrudnosciId = 1 // Przypisz poziom trudności
            ),
            PytanieEntity(
                id = 5,
                tresc = "Jaka jest stolica Hiszpanii?",
                odpATresc = "Paryż",
                odpBTresc = "Londyn",
                odpCTresc = "Rzym",
                odpDTresc = "Madryt",
                poprawna = 'D',
                poziomTrudnosciId = 1
            ),
            PytanieEntity(
                id = 6,
                tresc = "Ile wynosi 5 * 7?",
                odpATresc = "25",
                odpBTresc = "35",
                odpCTresc = "40",
                odpDTresc = "45",
                poprawna = 'B',
                poziomTrudnosciId = 1
            ),
            PytanieEntity(
                id = 7,
                tresc = "Kto napisał dramat 'Romeo i Julia'?",
                odpATresc = "William Shakespeare",
                odpBTresc = "George Orwell",
                odpCTresc = "Jane Austen",
                odpDTresc = "F. Scott Fitzgerald",
                poprawna = 'A',
                poziomTrudnosciId = 2
            ),
            PytanieEntity(
                id = 8,
                tresc = "Która planeta jest najbliżej Słońca?",
                odpATresc = "Mars",
                odpBTresc = "Jowisz",
                odpCTresc = "Ziemia",
                odpDTresc = "Merkury",
                poprawna = 'D',
                poziomTrudnosciId = 1
            ),
            PytanieEntity(
                id = 9,
                tresc = "Która rzeka przepływa przez Paryż?",
                odpATresc = "Tamiza",
                odpBTresc = "Sekwana",
                odpCTresc = "Renu",
                odpDTresc = "Dunaj",
                poprawna = 'B',
                poziomTrudnosciId = 2
            ),
            PytanieEntity(
                id = 10,
                tresc = "Który kraj jest znany jako 'Kraina Kwitnącej Wiśni'?",
                odpATresc = "Chiny",
                odpBTresc = "Japonia",
                odpCTresc = "Indie",
                odpDTresc = "Korea",
                poprawna = 'B',
                poziomTrudnosciId = 1
            ),
            PytanieEntity(
                id = 11,
                tresc = "Który pierwiastek chemiczny ma symbol 'Fe'?",
                odpATresc = "Fosfor",
                odpBTresc = "Fluor",
                odpCTresc = "Ferryt",
                odpDTresc = "Żelazo",
                poprawna = 'D',
                poziomTrudnosciId = 2
            ),
            PytanieEntity(
                id = 12,
                tresc = "Które państwo jest największe pod względem powierzchni?",
                odpATresc = "Rosja",
                odpBTresc = "Kanada",
                odpCTresc = "Stany Zjednoczone",
                odpDTresc = "Chiny",
                poprawna = 'A',
                poziomTrudnosciId = 1
            )
            // Dodaj więcej przykładowych pytań
        )
    }
}
