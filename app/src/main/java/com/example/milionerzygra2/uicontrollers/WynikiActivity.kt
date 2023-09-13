package com.example.milionerzygra2.uicontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.milionerzygra2.R
import com.example.milionerzygra2.controllers.WynikController
import com.example.milionerzygra2.databinding.ActivityNazwaUzytkownikaBinding
import com.example.milionerzygra2.databinding.ActivityWynikiBinding
import com.example.milionerzygra2.models.WynikModel
import com.example.milionerzygra2.recycleadapters.LeaderboardAdapter
import kotlinx.coroutines.launch

class WynikiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWynikiBinding;
    private lateinit var wynikController: WynikController;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWynikiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wynikController = WynikController(this);

        // Uruchom korutynę w kontekście onCreate
        lifecycleScope.launch {
            val wyniki = wynikController.DajWszystkieWynikiPosortowaneByWynikDesc()

            val recyclerView: RecyclerView = binding.recycleViewWyniki
            recyclerView.layoutManager = LinearLayoutManager(this@WynikiActivity)

            // Stwórz i ustaw adapter
            val adapter = LeaderboardAdapter(this@WynikiActivity, wyniki)
            recyclerView.adapter = adapter
        }
    }
}