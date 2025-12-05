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
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import com.example.ptbfix.R
import com.example.ptbfix.ui.components.AppTopBar
import com.example.ptbfix.ui.theme.PTBfixTheme

// File ini berisi implementasi layar Daftar (ListScreen)
// yang menampilkan daftar atlet dan pengurus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen() {
    // State untuk menentukan apakah yang ditampilkan adalah daftar atlet (true) atau pengurus (false)
    var showAtlet by remember { mutableStateOf(true) }
    
    // Scaffold sebagai layout utama yang menyediakan struktur dasar Material Design
    // termasuk AppBar, FloatingActionButton, dll.
    Scaffold(
        // AppBar di bagian atas layar
        topBar = {
            AppTopBar(title = "Daftar")  // Menampilkan judul "Daftar" di AppBar
        }
    ) { padding ->
        // Kolom utama untuk menata konten secara vertikal
        Column(
            modifier = Modifier
                .fillMaxSize()  // Mengisi seluruh ruang yang tersedia
                .padding(padding)  // Padding untuk menghindari tumpang tindih dengan system bars
                .background(Color.White)  // Latar belakang putih
        ) {
            // Baris untuk tombol Atlet dan Pengurus
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Tombol Atlet
                Button(
                    onClick = { showAtlet = true },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (showAtlet) 
                            Color(0xFF2196F3)  // Biru untuk tombol aktif
                        else 
                            Color(0xFFE3F2FD),  // Biru muda untuk tombol tidak aktif
                        contentColor = if (showAtlet) 
                            Color.White 
                        else 
                            Color(0xFF1976D2)  // Biru tua untuk teks
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.atlet),
                        contentDescription = "Atlet",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Atlet")
                }

                // Tombol Pengurus
                Button(
                    onClick = { showAtlet = false },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!showAtlet) 
                            Color(0xFF2196F3)  // Biru untuk tombol aktif
                        else 
                            Color(0xFFE3F2FD),  // Biru muda untuk tombol tidak aktif
                        contentColor = if (!showAtlet) 
                            Color.White 
                        else 
                            Color(0xFF1976D2)  // Biru tua untuk teks
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.pengurus),
                        contentDescription = "Pengurus",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Pengurus")
                }
            }

            // Menampilkan teks atau tombol berdasarkan state yang aktif
            if (showAtlet) {
                // Tombol Tambah Atlet
                Button(
                    onClick = { 
                        // TODO: Tambahkan aksi untuk menambahkan atlet baru
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.tambah),
                        contentDescription = "Tambah Atlet",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Tambah Atlet")
                }
            } else {
                // Menampilkan teks Daftar Pengurus
                Text(
                    text = "Daftar Pengurus",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1976D2)
                )
            }
        }
    }
}

// Preview untuk melihat tampilan di Android Studio
@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    // Menerapkan tema aplikasi pada preview
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            ListScreen()
        }
    }
}
