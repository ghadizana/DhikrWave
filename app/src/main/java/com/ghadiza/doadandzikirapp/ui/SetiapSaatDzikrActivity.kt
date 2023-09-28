package com.ghadiza.doadandzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghadiza.doadandzikirapp.R
import com.ghadiza.doadandzikirapp.adapter.DzikrDoaAdapter
import com.ghadiza.doadandzikirapp.model.DataDzikrDoa

class SetiapSaatDzikrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_setiap_saat_dzikr)

        val rvSetiapSaatDzikr = findViewById<RecyclerView>(R.id.rv_dzikr_setiap_saat)
        rvSetiapSaatDzikr.layoutManager = LinearLayoutManager(this)
        rvSetiapSaatDzikr.adapter = DzikrDoaAdapter(DataDzikrDoa.listDzikr)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}