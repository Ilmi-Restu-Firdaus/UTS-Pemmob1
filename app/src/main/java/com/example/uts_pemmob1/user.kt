package com.example.uts_pemmob1

// Data class untuk menyimpan informasi pengguna
data class User(val username: String, val password: String)

// Objek UserData untuk menyimpan daftar pengguna (userList)
object UserData {
    // Menggunakan ArrayList untuk menyimpan data pengguna
    val userList = ArrayList<User>()
}
