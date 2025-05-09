package com.example.uts_pemmob1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent  // Import class Intent

// Activity yang menampilkan splash screen sebelum pindah ke halaman login
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan mode full screen dengan edge-to-edge support
        setContentView(R.layout.activity_splash_screen) // Menetapkan layout untuk splash screen

        // Menyesuaikan padding agar konten tidak tertutup oleh sistem UI (seperti status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Splashmain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menunda navigasi ke halaman login setelah 2,4 detik
        Handler(Looper.getMainLooper()).postDelayed({
            // Pindah ke halaman login setelah splash screen selesai
            startActivity(Intent(this, Login::class.java))
            finish() // Menutup splash screen setelah pindah ke halaman login
        }, 2400) // Durasi splash screen adalah 2400 milidetik (2,4 detik)
    }
}
