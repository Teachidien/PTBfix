// Mendeklarasikan package tempat file ini berada
package com.example.ptbfix.ui.screens

// Import library yang dibutuhkan
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import com.example.ptbfix.R
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
        // Scaffold adalah layout dasar yang menyediakan struktur untuk aplikasi Material Design
        // termasuk AppBar, FloatingActionButton, dll.
        Scaffold(
            // Mendefinisikan top bar/AppBar
            topBar = {
                TopAppBar(
                    // Judul halaman
                    title = { Text("Tim") },
                    // Icon di sebelah kiri judul
                    navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.team),
                            contentDescription = "Tim", // Penting untuk aksesibilitas
                            modifier = Modifier
                                .padding(start = 16.dp)  // Memberi jarak dari kiri
                                .size(24.dp)  // Mengatur ukuran icon
                        )
                    }
                )
            }
        ) { padding ->  // Padding dari Scaffold untuk menghindari tumpang tindih dengan system UI
            // Box sebagai container utama untuk konten
            Box(
                modifier = Modifier
                    .fillMaxSize()  // Mengisi seluruh ruang yang tersedia
                    .padding(padding),  // Menerapkan padding dari Scaffold
                contentAlignment = Alignment.Center  // Posisi konten di tengah
            ) {
                // Column untuk menata konten secara vertikal
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Menampilkan ikon tim
                    Icon(
                        painter = painterResource(id = R.drawable.team),
                        contentDescription = "Tim",  // Deskripsi untuk aksesibilitas
                        modifier = Modifier
                            .size(64.dp)  // Ukuran ikon
                            .clip(CircleShape)  // Memotong ikon menjadi bentuk lingkaran
                    )
                    // Memberi jarak vertikal antara ikon dan teks
                    Spacer(modifier = Modifier.height(16.dp))
                    // Teks sambutan
                    Text("Welcome Halaman Tim")
                }
            }
        }
    }
}

/**
 * Preview Composable untuk menampilkan pratinjau TeamScreen di Android Studio
 * @showBackground - Menampilkan latar belakang di preview
 * @showSystemUi - Menampilkan system UI di preview
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TeamScreenPreview() {
    // Menerapkan tema yang sama dengan aplikasi
    PTBfixTheme {
        // Surface sebagai container untuk preview
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Memanggil TeamScreen untuk ditampilkan di preview
            TeamScreen()
        }
    }
}
