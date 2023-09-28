package com.ghadiza.doadandzikirapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghadiza.doadandzikirapp.R
import com.ghadiza.doadandzikirapp.adapter.DzikrDoaAdapter
import com.ghadiza.doadandzikirapp.model.DataDzikrDoa

class DzikrPagiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikr_pagi)

        val rvDzikrPagi = findViewById<RecyclerView>(R.id.rv_dzikr_pagi)
        rvDzikrPagi.layoutManager = LinearLayoutManager(this)
        rvDzikrPagi.adapter = DzikrDoaAdapter(DataDzikrDoa.listDzikrPagi)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}