package com.example.uts_pemmob1

import android.content.Intent
import android.os.Bundle
import android.util.Log // Import untuk Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

// Activity untuk halaman registrasi pengguna baru
class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan mode full screen dengan edge-to-edge support
        setContentView(R.layout.activity_register) // Menetapkan layout untuk activity_register

        // Menyesuaikan padding agar konten tidak tertutup oleh sistem UI (seperti status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi komponen UI
        val username = findViewById<EditText>(R.id.usernm)
        val pass = findViewById<EditText>(R.id.passw)
        val pass2 = findViewById<EditText>(R.id.passw2)
        val btnRegister = findViewById<Button>(R.id.butreq)

        // Event ketika tombol register ditekan
        btnRegister.setOnClickListener {
            val user = username.text.toString() // Ambil username yang dimasukkan
            val pw1 = pass.text.toString()     // Ambil password pertama
            val pw2 = pass2.text.toString()    // Ambil password kedua

            // Menambahkan event log untuk proses registrasi
            Log.d("RegisterActivity", "Button Register clicked")

            // Cek apakah ada field yang kosong
            if (user.isBlank() || pw1.isBlank() || pw2.isBlank()) {
                Toast.makeText(this, "Username atau password harus diisi", Toast.LENGTH_SHORT).show()
                Log.d("RegisterActivity", "Fields are blank") // Log jika ada field kosong
            } 
            // Cek apakah password yang dimasukkan cocok
            else if (pw1 != pw2) {
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
                Log.d("RegisterActivity", "Passwords do not match") // Log jika password tidak cocok
            } 
            // Jika validasi berhasil, simpan data user dan lanjut ke halaman login
            else {
                UserData.userList.add(User(user, pw1)) // Menambahkan user baru ke UserData
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                Log.d("RegisterActivity", "Registration successful") // Log ketika registrasi berhasil

                startActivity(Intent(this, Login::class.java)) // Pindah ke halaman login
                finish() // Tutup halaman registrasi
            }
        }

        // Listener untuk kembali ke halaman login saat icon back ditekan
        btnbackregisterListener()
        // Listener untuk kembali ke halaman login saat teks "Go to login" ditekan
        btnbackgologinListener()
    }

    // Fungsi untuk menangani klik pada icon back
    private fun btnbackregisterListener() {
        val icback = findViewById<ImageView>(R.id.icback)
        icback.setOnClickListener {
            startActivity(Intent(this, Login::class.java)) // Pindah ke halaman login
        }
    }

    // Fungsi untuk menangani klik pada teks "Go to login"
    private fun btnbackgologinListener() {
        val gologin1 = findViewById<TextView>(R.id.gologin1)
        gologin1.setOnClickListener {
            startActivity(Intent(this, Login::class.java)) // Pindah ke halaman login
        }
    }
}
