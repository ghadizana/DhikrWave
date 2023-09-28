package com.ghadiza.doadandzikirapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghadiza.doadandzikirapp.R
import com.ghadiza.doadandzikirapp.adapter.DzikrDoaAdapter
import com.ghadiza.doadandzikirapp.model.DataDzikrDoa

class DzikrPetangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikr_petang)

        val rvDzikrPetang = findViewById<RecyclerView>(R.id.rv_dzikr_petang)
        rvDzikrPetang.layoutManager = LinearLayoutManager(this)
        rvDzikrPetang.adapter = DzikrDoaAdapter(DataDzikrDoa.listDzikrPetang)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}