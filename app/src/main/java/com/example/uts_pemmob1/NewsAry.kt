package com.example.uts_pemmob1

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

// Activity untuk menampilkan daftar berita di layar
class NewsAryActivity : AppCompatActivity() {

    // Deklarasi ListView dan ArrayList untuk menampung data berita
    private lateinit var listViewBerita: ListView
    private lateinit var beritaList: ArrayList<Berita>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_ary) // Menetapkan layout activity_news_ary

        // Inisialisasi ListView untuk menampilkan daftar berita
        listViewBerita = findViewById(R.id.listViewBerita)

        // Membuat data berita yang akan ditampilkan
        beritaList = arrayListOf(
            // Menambahkan beberapa berita dengan gambar, judul, dan deskripsi
            Berita(R.drawable.gta, "Peluncuran GTA 6 Ditunda", "ROCKSTAR Games mengumumkan peluncuran Grand Theft Auto VI (GTA 6) akan diundur."),
            Berita(R.drawable.stardew, "Tidak akan ada lagi update Stardew Valley", "Developer Stardew Valley tidak akan memberikan Update lagi sampai game ke 2 nya release."),
            Berita(R.drawable.elden, "Elden Ring Sukses Tembus Penjualan 30 Juta Copy di Seluruh Dunia", "Berbekal pengalaman mereka sebagai pencetus game bergenre soulslike yang semakin diminati pasar, pada 2022 lalu FromSoftware semakin mencapai puncak kesuksesan mainstream berkat Elden Ring."),
            Berita(R.drawable.wuwajpg, "Wuthering Waves Sudah Tersedia untuk Wishlist di Steam!", "Dengan semakin tingginya production value dari game-game gacha di era sekarang, ini juga berguna untuk memperluas ekspansinya ke berbagai platform, yang tentu bisa sangat menguntungkan bagi pihak developer serta publisher dalam menggaet lebih banyak pemain baru.")
        )

        // Menetapkan adapter ke ListView untuk menampilkan data berita
        val adapter = BeritaAdapter(this, beritaList)
        listViewBerita.adapter = adapter // Menghubungkan adapter dengan ListView
    }
}
