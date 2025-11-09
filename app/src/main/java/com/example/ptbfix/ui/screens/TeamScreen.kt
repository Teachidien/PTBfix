package com.example.ptbfix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ptbfix.ui.components.AppTopBar
import com.example.ptbfix.ui.theme.PTBfixTheme

/**
 * Composable function yang menampilkan halaman Tim
 * Menggunakan Material3 dan experimental API dari Compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamScreen() {
    // Menerapkan tema kustom PTBfix
    PTBfixTheme {
        Scaffold(
            topBar = {
                AppTopBar(title = "Tim")
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                // Konten halaman bisa ditambahkan di sini
            }
        }
    }
}

/**
 * Preview Composable untuk menampilkan pratinjau TeamScreen di Android Studio
 * @showBackground - Menampilkan latar belakang di preview
 */
@Preview(showBackground = true)
@Composable
fun TeamScreenPreview() {
    // Menerapkan tema yang sama dengan aplikasi
    PTBfixTheme {
        // Surface sebagai container untuk preview
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            // Memanggil TeamScreen untuk ditampilkan di preview
            TeamScreen()
        }
    }
}
