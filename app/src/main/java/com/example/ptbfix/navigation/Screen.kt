package com.example.ptbfix.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Absen : Screen("absen")
    object Event : Screen("event")
    object List : Screen("list")
    object Team : Screen("team")
}
