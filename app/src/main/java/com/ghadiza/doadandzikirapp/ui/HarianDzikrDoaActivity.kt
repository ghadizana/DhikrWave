package com.ghadiza.doadandzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghadiza.doadandzikirapp.R
import com.ghadiza.doadandzikirapp.adapter.DzikrDoaAdapter
import com.ghadiza.doadandzikirapp.model.DzikrDoa

class HarianDzikrDoaActivity : AppCompatActivity() {
    private val listDzikr: ArrayList<DzikrDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_harian_dzikr_doa)

        initData()

        val rvDzikrDoaHarian = findViewById<RecyclerView>(R.id.rv_dzikr_doa_harian)
        rvDzikrDoaHarian.layoutManager = LinearLayoutManager(this)
        rvDzikrDoaHarian.adapter = DzikrDoaAdapter(listDzikr)
    }

    private fun initData() {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (data in desc.indices) {
            val dzikr = DzikrDoa(
                desc[data],
                lafaz[data],
                terjemah[data]
            )
            listDzikr.add(dzikr)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}