package com.ghadiza.doadandzikirapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.ghadiza.doadandzikirapp.R
import com.ghadiza.doadandzikirapp.ui.detail.DzikrPagiActivity
import com.ghadiza.doadandzikirapp.ui.detail.DzikrPetangActivity

class PagiPetangDzikrActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_pagi_petang_dzikr)

        val cvDzikrPagi: CardView = findViewById(R.id.cv_dzikr_pagi)
        cvDzikrPagi.setOnClickListener(this)
        val btnDzikrPagi: ImageButton = findViewById(R.id.img_btn_dzikr_pagi)
        btnDzikrPagi.setOnClickListener(this)

        val cvDzikrPetang: CardView = findViewById(R.id.cv_dzikr_petang)
        cvDzikrPetang.setOnClickListener(this)
        val btnDzikrPetang: ImageButton = findViewById(R.id.img_btn_dzikr_petang)
        btnDzikrPetang.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.img_btn_dzikr_pagi -> startActivity(Intent(this, DzikrPagiActivity::class.java))

            R.id.cv_dzikr_petang -> startActivity(Intent(this, DzikrPetangActivity::class.java))
            R.id.img_btn_dzikr_petang -> startActivity(Intent(this, DzikrPetangActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}