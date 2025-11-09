package com.example.ptbfix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ptbfix.R
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
            },
            floatingActionButton = {
                // Tombol Tambah di pojok kanan bawah
                FloatingActionButton(
                    onClick = { /* Aksi saat tombol tambah diklik */ },
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.tambah),
                        contentDescription = "Tambah Tim",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Daftar tim akan ditampilkan di sini")
                }
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
