package com.example.ptbfix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ptbfix.R
import com.example.ptbfix.ui.components.AppTopBar
import com.example.ptbfix.ui.theme.PTBfixTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen() {
    Scaffold(
        topBar = {
            AppTopBar(title = "Event")
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
                    contentDescription = "Tambah Event",
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
            // Konten halaman bisa ditambahkan di sini
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Daftar event akan ditampilkan di sini")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventScreenPreview() {
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            EventScreen()
        }
    }
}
