package com.example.ptbfix.navigation

/**
 * Kelas sealed untuk mendefinisikan rute-rute navigasi dalam aplikasi.
 * Setiap objek merepresentasikan satu layar dalam aplikasi.
 * @property route String yang unik untuk mengidentifikasi setiap layar
 */
sealed class Screen(val route: String) {
    // Layar beranda aplikasi
    object Home : Screen("home")
    
    // Layar untuk fitur absensi
    object Absen : Screen("absen")
    
    // Layar untuk menampilkan event
    object Event : Screen("event")
    
    // Layar untuk menampilkan daftar
    object List : Screen("list")
    
    // Layar untuk menampilkan tim
    object Team : Screen("team")
}
