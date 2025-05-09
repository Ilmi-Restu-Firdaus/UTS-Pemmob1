package com.example.uts_pemmob1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// Adapter ini digunakan untuk menampilkan data Berita ke dalam komponen ListView
class BeritaAdapter(
    private val context: Context,             // Context untuk akses layout inflater dan resource
    private val beritaList: List<Berita>      // List data berita yang akan ditampilkan
) : BaseAdapter() {

    // Mengembalikan jumlah item dalam list
    override fun getCount(): Int = beritaList.size

    // Mengembalikan item pada posisi tertentu
    override fun getItem(position: Int): Any = beritaList[position]

    // Mengembalikan ID item (di sini cukup gunakan posisi sebagai ID)
    override fun getItemId(position: Int): Long = position.toLong()

    // Membuat dan mengembalikan tampilan (View) untuk setiap item
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Inflate layout item_berita untuk setiap baris dalam ListView
        val view = LayoutInflater.from(context).inflate(R.layout.item_berita, parent, false)

        // Ambil referensi ke komponen-komponen dalam layout
        val imgBerita = view.findViewById<ImageView>(R.id.imgBerita)
        val txtJudul = view.findViewById<TextView>(R.id.txtJudul)
        val txtDeskripsi = view.findViewById<TextView>(R.id.txtDeskripsi)

        // Ambil data berita sesuai posisi
        val berita = beritaList[position]

        // Isi komponen layout dengan data dari objek Berita
        imgBerita.setImageResource(berita.gambar)
        txtJudul.text = berita.judul
        txtDeskripsi.text = berita.deskripsi

        return view
    }
}
