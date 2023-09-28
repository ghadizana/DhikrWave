package com.ghadiza.doadandzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghadiza.doadandzikirapp.R
import com.ghadiza.doadandzikirapp.adapter.DzikrDoaAdapter
import com.ghadiza.doadandzikirapp.model.DataDzikrDoa

class QauliyahShalatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_qauliyah_shalat)

        val rvQauliyah = findViewById<RecyclerView>(R.id.rv_qauliyah_shalat)
        rvQauliyah.layoutManager = LinearLayoutManager(this)
        rvQauliyah.adapter = DzikrDoaAdapter(DataDzikrDoa.listQauliyah)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}