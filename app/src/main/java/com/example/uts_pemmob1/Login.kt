package com.example.uts_pemmob1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Toast

// Activity untuk halaman login
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan mode full screen dengan edge-to-edge support
        setContentView(R.layout.activity_login)

        // Menyesuaikan padding agar konten tidak tertutup oleh sistem UI (seperti status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referensi ke komponen UI
        val username = findViewById<EditText>(R.id.l_usernm)
        val password = findViewById<EditText>(R.id.l_passw)
        val btnLogin = findViewById<Button>(R.id.logindas)

        // Event ketika tombol login ditekan
        btnLogin.setOnClickListener {
            val userInput = username.text.toString()
            val passInput = password.text.toString()

            // Cek apakah ada user yang cocok dalam UserData
            val found = UserData.userList.any { it.username == userInput && it.password == passInput }

            if (found) {
                // Jika cocok, tampilkan pesan dan pindah ke MainActivity
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Jika tidak cocok, tampilkan pesan gagal
                Toast.makeText(this, "Login gagal. Cek username atau password.", Toast.LENGTH_SHORT).show()
            }
        }

        // Menambahkan listener untuk teks "Belum punya akun?"
        btnregisterListener()
    }

    // Fungsi untuk menangani klik pada teks register
    private fun btnregisterListener() {
        val regispage1 = findViewById<TextView>(R.id.regispage1)
        regispage1.setOnClickListener {
            // Arahkan ke halaman registrasi
            startActivity(Intent(this, Register::class.java))
        }
    }
}
