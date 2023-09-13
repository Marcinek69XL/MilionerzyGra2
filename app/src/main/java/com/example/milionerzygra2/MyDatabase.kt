package com.example.milionerzygra2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.milionerzygra2.daos.PoziomTrudnosciDao
import com.example.milionerzygra2.daos.PytanieDao
import com.example.milionerzygra2.daos.WynikUzytkownikaDao
import com.example.milionerzygra2.entities.PoziomTrudnosciEntity
import com.example.milionerzygra2.entities.PytanieEntity
import com.example.milionerzygra2.entities.WynikEntity
import com.example.milionerzygra2.seeders.PoziomTrudnosciSeeder
import com.example.milionerzygra2.seeders.PytanieSeeder

@Database(entities = [PytanieEntity::class, PoziomTrudnosciEntity::class, WynikEntity::class], version = 10, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun pytanieDao(): PytanieDao
    abstract fun poziomTrudnosciDao(): PoziomTrudnosciDao
    abstract fun wynikUzytkownikaDao() : WynikUzytkownikaDao

    companion object {
        @Volatile
        private var Instance: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = Instance
            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "pytanie_database" // Dodaj nazwę bazy danych
                )
                    .fallbackToDestructiveMigration()
                    .build()

                // seedowanie

                if (instance.poziomTrudnosciDao().getAllPoziomyTrunosci().isEmpty()) {
                    // Jeśli baza danych jest pusta, wypełnij ją danymi

                    val seeder = PoziomTrudnosciSeeder();
                    val poziomy = seeder.getPoziomyTrudnosci();

                    instance.poziomTrudnosciDao().insertAll(poziomy);
                }

                if (instance.pytanieDao().getAllPytania().isEmpty()) {
                    // Jeśli baza danych jest pusta, wypełnij ją danymi
                    val seeder = PytanieSeeder();
                    val pytania = seeder.getPrzykladowePytania();

                    instance.pytanieDao().insertAll(pytania);
                }

                Instance = instance
                return instance
            }
        }
    }
}