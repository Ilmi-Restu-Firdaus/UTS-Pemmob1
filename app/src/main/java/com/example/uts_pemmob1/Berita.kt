package com.example.uts_pemmob1

// Data class Berita merepresentasikan satu entitas berita
data class Berita(
    val gambar: Int,        // ID resource untuk gambar berita (biasanya R.drawable.nama_gambar)
    val judul: String,      // Judul dari berita
    val deskripsi: String   // Deskripsi atau isi dari berita
)
