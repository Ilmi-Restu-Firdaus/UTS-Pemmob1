package com.example.uts_pemmob1

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

// Activity utama untuk menampilkan daftar berita
class MainActivity : AppCompatActivity() {

    // Deklarasi ListView dan ArrayList untuk menampung data berita
    private lateinit var listView: ListView
    private lateinit var beritaList: ArrayList<Berita>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi ListView untuk menampilkan daftar berita
        listView = findViewById(R.id.listViewBerita)

        // Membuat daftar objek berita yang akan ditampilkan di ListView
        beritaList = arrayListOf(
            // Menambahkan beberapa berita dengan gambar, judul, dan deskripsi
            Berita(R.drawable.gta, "Peluncuran GTA 6 Ditunda", "ROCKSTAR Games mengumumkan peluncuran Grand Theft Auto VI (GTA 6) akan diundur."),
            Berita(R.drawable.stardew, "Tidak akan ada lagi update Stardew Valley", "Developer Stardew Valley tidak akan memberikan Update lagi sampai game ke 2 nya release."),
            Berita(R.drawable.elden, "Elden Ring Sukses Tembus Penjualan 30 Juta Copy", "Berbekal pengalaman mereka sebagai pencetus game bergenre soulslike, Elden Ring mencapai kesuksesan mainstream."),
            Berita(R.drawable.wuwajpg, "Wuthering Waves Sudah Tersedia untuk Wishlist di Steam", "Dengan tingginya production value, Wuthering Waves sudah bisa ditambahkan ke wishlist di Steam.")
        )

        // Menyiapkan adapter untuk menghubungkan data berita dengan tampilan ListView
        val adapter = BeritaAdapter(this, beritaList)
        listView.adapter = adapter // Menetapkan adapter ke ListView
    }
}
