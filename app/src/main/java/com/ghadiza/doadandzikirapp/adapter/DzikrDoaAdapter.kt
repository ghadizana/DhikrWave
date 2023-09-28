package com.ghadiza.doadandzikirapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ghadiza.doadandzikirapp.R
import com.ghadiza.doadandzikirapp.model.DzikrDoa

class DzikrDoaAdapter(private val listDzikrDoa: ArrayList<DzikrDoa>) : RecyclerView.Adapter<DzikrDoaAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // initialization view dari layout row_item_dzikr.xml

        val tvDesc: TextView = view.findViewById(R.id.tv_desc)
        val tvLafaz: TextView = view.findViewById(R.id.tv_lafaz)
        val tvTerjemah: TextView = view.findViewById(R.id.tv_terjemah)
    }

    // menampilkan data sesuai dengan posisi layout yang ditentukan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikr_doa, parent, false)
    )

    // menentukan jumlah data yang ditampilkan
    override fun getItemCount() = listDzikrDoa.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // mengatur data dengan tampilan
        holder.tvDesc.text = listDzikrDoa[position].desc
        holder.tvLafaz.text = listDzikrDoa[position].lafaz
        holder.tvTerjemah.text = listDzikrDoa[position].terjemah
    }

}