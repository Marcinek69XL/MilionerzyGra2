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
            ),

            PytanieEntity(
            id = 13,
            tresc = "Z gry na jakim instrumencie słynie Czesław Mozil?",
            odpATresc = "Na kornecie",
            odpBTresc = "Na akordeonie",
            odpCTresc = "Na djembe",
            odpDTresc = "Na ksylofonie",
            poprawna = 'B',
            poziomTrudnosciId = 2
             ),
            PytanieEntity(
                id = 14,
                tresc = "Z gry na jakim instrumencie słynie Czesław Mozil?",
                odpATresc = "Na kornecie",
                odpBTresc = "Na akordeonie",
                odpCTresc = "Na djembe",
                odpDTresc = "Na ksylofonie",
                poprawna = 'B',
                poziomTrudnosciId = 2
            ),
            PytanieEntity(
                id = 15,
                tresc = "Który z tych przypraw jest najdroższy na świecie?",
                odpATresc = "Cynamon",
                odpBTresc = "Szafran",
                odpCTresc = "Kurkuma",
                odpDTresc = "Pieprz czarny",
                poprawna = 'B',
                poziomTrudnosciId = 3
            ),

            PytanieEntity(
                id = 16,
                tresc = "Który kraj jest największym producentem oliwy z oliwek na świecie?",
                odpATresc = "Hiszpania",
                odpBTresc = "Włochy",
                odpCTresc = "Grecja",
                odpDTresc = "Turcja",
                poprawna = 'A',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 17,
                tresc = "Która z planet Układu Słonecznego jest najmniejsza?",
                odpATresc = "Merkury",
                odpBTresc = "Wenus",
                odpCTresc = "Mars",
                odpDTresc = "Pluton",
                poprawna = 'A',
                poziomTrudnosciId = 1
            ),

            PytanieEntity(
                id = 18,
                tresc = "Który fizyk uznawany jest za ojca teorii względności?",
                odpATresc = "Isaac Newton",
                odpBTresc = "Niels Bohr",
                odpCTresc = "Albert Einstein",
                odpDTresc = "Marie Curie",
                poprawna = 'C',
                poziomTrudnosciId = 1
            ),

            PytanieEntity(
                id = 19,
                tresc = "Który ocean jest największy pod względem powierzchni?",
                odpATresc = "Ocean Atlantycki",
                odpBTresc = "Ocean Spokojny",
                odpCTresc = "Ocean Indyjski",
                odpDTresc = "Ocean Arktyczny",
                poprawna = 'B',
                poziomTrudnosciId = 2
            ),
            PytanieEntity(
                id = 20,
                tresc = "Która planeta Układu Słonecznego jest znana jako 'Planeta Czerwona'?",
                odpATresc = "Merkury",
                odpBTresc = "Mars",
                odpCTresc = "Jowisz",
                odpDTresc = "Saturn",
                poprawna = 'B',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 21,
                tresc = "Która z tych państwowych świątyń jest największa na świecie?",
                odpATresc = "Świątynia w Amritsar",
                odpBTresc = "Świątynia w Angkor Wat",
                odpCTresc = "Świątynia w Mekce",
                odpDTresc = "Świątynia w Wat Pho",
                poprawna = 'B',
                poziomTrudnosciId = 3
            ),

            PytanieEntity(
                id = 22,
                tresc = "Która z rzek jest najdłuższą rzeką na świecie?",
                odpATresc = "Nil",
                odpBTresc = "Amazonka",
                odpCTresc = "Missisipi",
                odpDTresc = "Jangcy",
                poprawna = 'A',
                poziomTrudnosciId = 1
            ),

            PytanieEntity(
                id = 23,
                tresc = "Który z tych filmów jest adaptacją powieści J.K. Rowling?",
                odpATresc = "Matrix",
                odpBTresc = "Harry Potter i Kamień Filozoficzny",
                odpCTresc = "Incepcja",
                odpDTresc = "Transformers",
                poprawna = 'B',
                poziomTrudnosciId = 1
            ),

            PytanieEntity(
                id = 24,
                tresc = "Które z tych zwierząt jest ssakiem?",
                odpATresc = "Żółw",
                odpBTresc = "Rekin",
                odpCTresc = "Delfin",
                odpDTresc = "Krokodyl",
                poprawna = 'C',
                poziomTrudnosciId = 1
            ),

            PytanieEntity(
                id = 25,
                tresc = "Który kraj jest największym producentem ropy naftowej na świecie?",
                odpATresc = "Stany Zjednoczone",
                odpBTresc = "Arabia Saudyjska",
                odpCTresc = "Rosja",
                odpDTresc = "Chiny",
                poprawna = 'B',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 26,
                tresc = "Który z tych aktorów zagrał główną rolę w filmie 'Forrest Gump'?",
                odpATresc = "Tom Cruise",
                odpBTresc = "Harrison Ford",
                odpCTresc = "Denzel Washington",
                odpDTresc = "Tom Hanks",
                poprawna = 'D',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 27,
                tresc = "Który pierwiastek chemiczny jest symbolizowany literą 'Fe' w układzie okresowym?",
                odpATresc = "Węgiel",
                odpBTresc = "Tlen",
                odpCTresc = "Żelazo",
                odpDTresc = "Sód",
                poprawna = 'C',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 28,
                tresc = "Który z tych znanych malarzy był hiszpańskim surrealistą?",
                odpATresc = "Vincent van Gogh",
                odpBTresc = "Pablo Picasso",
                odpCTresc = "Leonardo da Vinci",
                odpDTresc = "Rembrandt",
                poprawna = 'B',
                poziomTrudnosciId = 3
            ),

            PytanieEntity(
                id = 29,
                tresc = "Który z tych sportów jest często nazywany 'królem sportów'?",
                odpATresc = "Hokej",
                odpBTresc = "Piłka nożna",
                odpCTresc = "Boks",
                odpDTresc = "Koszykówka",
                poprawna = 'B',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 30,
                tresc = "Która z tych stolic jest najbliżej równika?",
                odpATresc = "Kopenhaga",
                odpBTresc = "Oslo",
                odpCTresc = "Nairobi",
                odpDTresc = "Lima",
                poprawna = 'C',
                poziomTrudnosciId = 3
            ),

            PytanieEntity(
                id = 31,
                tresc = "Który z tych przyrodników znany jest z teorii ewolucji przez dobór naturalny?",
                odpATresc = "Marie Curie",
                odpBTresc = "Isaac Newton",
                odpCTresc = "Albert Einstein",
                odpDTresc = "Charles Darwin",
                poprawna = 'D',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 32,
                tresc = "Które z tych państw leży w Afryce?",
                odpATresc = "Australia",
                odpBTresc = "Brazylia",
                odpCTresc = "Egipt",
                odpDTresc = "Japonia",
                poprawna = 'C',
                poziomTrudnosciId = 1
            ),

            PytanieEntity(
                id = 33,
                tresc = "Który kolor jest wynikiem połączenia czerwieni i niebieskiego?",
                odpATresc = "Zielony",
                odpBTresc = "Żółty",
                odpCTresc = "Fioletowy",
                odpDTresc = "Pomarańczowy",
                poprawna = 'C',
                poziomTrudnosciId = 1
            ),


            PytanieEntity(
                id = 35,
                tresc = "Który z tych aktorów zagrał Jamesa Bonda w filmie 'Casino Royale'?",
                odpATresc = "Pierce Brosnan",
                odpBTresc = "Daniel Craig",
                odpCTresc = "Roger Moore",
                odpDTresc = "Sean Connery",
                poprawna = 'B',
                poziomTrudnosciId = 3
            ),

            PytanieEntity(
                id = 36,
                tresc = "Który z tych znanych malarzy jest autorem obrazu 'Mona Lisa'?",
                odpATresc = "Pablo Picasso",
                odpBTresc = "Vincent van Gogh",
                odpCTresc = "Leonardo da Vinci",
                odpDTresc = "Michelangelo",
                poprawna = 'C',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 37,
                tresc = "Który kraj jest największym producentem czekolady na świecie?",
                odpATresc = "Belgia",
                odpBTresc = "Szwajcaria",
                odpCTresc = "Niemcy",
                odpDTresc = "USA",
                poprawna = 'B',
                poziomTrudnosciId = 2
            ),

            PytanieEntity(
                id = 38,
                tresc = "Który z tych znanych wynalazców był odpowiedzialny za wynalezienie żarówki?",
                odpATresc = "Thomas Edison",
                odpBTresc = "Galileusz Galilei",
                odpCTresc = "Benjamin Franklin",
                odpDTresc = "Isaac Newton",
                poprawna = 'A',
                poziomTrudnosciId = 3
            ),

            PytanieEntity(
                id = 39,
                tresc = "Który z tych filmów jest częścią serii 'Star Wars'?",
                odpATresc = "Blade Runner",
                odpBTresc = "Interstellar",
                odpCTresc = "Guardians of the Galaxy",
                odpDTresc = "The Empire Strikes Back",
                poprawna = 'D',
                poziomTrudnosciId = 3
            ),

            PytanieEntity(
                id = 40,
                tresc = "Który z tych oceanów jest najmniejszy pod względem powierzchni?",
                odpATresc = "Ocean Atlantycki",
                odpBTresc = "Ocean Spokojny",
                odpCTresc = "Ocean Indyjski",
                odpDTresc = "Ocean Arktyczny",
                poprawna = 'D',
                poziomTrudnosciId = 1
            )
        )
    }
}