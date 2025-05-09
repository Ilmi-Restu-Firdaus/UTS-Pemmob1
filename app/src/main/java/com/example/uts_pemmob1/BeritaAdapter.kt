package com.example.uts_pemmob1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class BeritaAdapter(private val context: Context, private val beritaList: List<Berita>) : BaseAdapter() {

    override fun getCount(): Int = beritaList.size

    override fun getItem(position: Int): Any = beritaList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_berita, parent, false)

        val imgBerita = view.findViewById<ImageView>(R.id.imgBerita)
        val txtJudul = view.findViewById<TextView>(R.id.txtJudul)
        val txtDeskripsi = view.findViewById<TextView>(R.id.txtDeskripsi)

        val berita = beritaList[position]

        imgBerita.setImageResource(berita.gambar)
        txtJudul.text = berita.judul
        txtDeskripsi.text = berita.deskripsi

        return view
    }
}
