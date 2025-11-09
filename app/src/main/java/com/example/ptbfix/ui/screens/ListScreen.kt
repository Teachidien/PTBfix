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
fun ListScreen() {
    Scaffold(
        topBar = {
            AppTopBar(title = "Daftar")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            // Baris untuk tombol Atlet dan Pengurus
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Tombol Atlet
                Button(
                    onClick = { /* Aksi saat tombol Atlet diklik */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    )
                ) {
                    // Ikon Atlet dari file PNG
                    Icon(
                        painter = painterResource(id = R.drawable.atlet),
                        contentDescription = "Atlet",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Atlet",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Tombol Pengurus
                Button(
                    onClick = { /* Aksi saat tombol Pengurus diklik */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4CAF50) // Warna hijau
                    )
                ) {
                    // Ikon Pengurus dari file PNG
                    Icon(
                        painter = painterResource(id = R.drawable.pengurus),
                        contentDescription = "Pengurus",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Pengurus",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Area konten di bawah tombol
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Konten tambahan bisa ditambahkan di sini
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            ListScreen()
        }
    }
}
