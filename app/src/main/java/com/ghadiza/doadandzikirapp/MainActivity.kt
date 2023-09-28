package com.ghadiza.doadandzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.ghadiza.doadandzikirapp.adapter.ArtikelAdapter
import com.ghadiza.doadandzikirapp.model.Artikel
import com.ghadiza.doadandzikirapp.ui.HarianDzikrDoaActivity
import com.ghadiza.doadandzikirapp.ui.PagiPetangDzikrActivity
import com.ghadiza.doadandzikirapp.ui.QauliyahShalatActivity
import com.ghadiza.doadandzikirapp.ui.SetiapSaatDzikrActivity

class MainActivity : AppCompatActivity() {

    private val listArtikel: ArrayList<Artikel> = arrayListOf()
    private lateinit var dotSlider: Array<ImageView?>
    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                dotSlider[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }

            dotSlider[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        initData()
        initView()
        setupViewPage()
    }

    private fun setupViewPage() {
        val llSliderDots : LinearLayout = findViewById(R.id.ll_slider_dots)
        dotSlider = arrayOfNulls(listArtikel.size)
        for (i in 0 until listArtikel.size) {
            dotSlider[i] = ImageView(this)
            dotSlider[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )

            // menentukan lebar dan tinggi indikator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            // mengatur jarak antara indikator
            params.setMargins(9,0,8,0)

            // mengatur posisi indikator
            params.gravity = Gravity.CENTER_VERTICAL

            llSliderDots.addView(dotSlider[i], params)
        }

        dotSlider[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_active
            )
        )
    }

    private fun initData() {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (data in titleArtikel.indices) {
            val artikel = Artikel(
                titleArtikel[data],
                descArtikel[data],
                imgArtikel.getResourceId(data, 0)
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }

    private fun initView() {
        val imgBtnDzikrDoaSolat: ImageButton = findViewById(R.id.img_btn_dzikr_doa_solat)
        imgBtnDzikrDoaSolat.setOnClickListener {
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }

        val imgBtnDzikirSetelahSalat: ImageButton = findViewById(R.id.img_btn_dzikir_setelah_shalat)
        imgBtnDzikirSetelahSalat.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikrActivity::class.java))
        }

        val imgBtnDzikirDoaHarian: ImageButton = findViewById(R.id.img_btn_dzikir_doa_harian)
        imgBtnDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikrDoaActivity::class.java))
        }

        val imgBtnDzikirPagiPetang: ImageButton = findViewById(R.id.img_btn_dzikir_pagi_petang)
        imgBtnDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikrActivity::class.java))
        }

        val vpArtikel: ViewPager2 = findViewById(R.id.vp_artikel)
        vpArtikel.adapter = ArtikelAdapter(listArtikel)
        vpArtikel.registerOnPageChangeCallback(slidingCallback)
    }
}