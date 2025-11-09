// Mendeklarasikan package tempat file ini berada
package com.example.ptbfix

// Import library Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Import library Compose UI
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Import Navigation Component
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// Import komponen kustom
import com.example.ptbfix.navigation.Screen
import com.example.ptbfix.ui.theme.PTBfixTheme

/**
 * Komponen utama yang menangani navigasi antar layar dalam aplikasi.
 * Menggunakan Scaffold dengan BottomAppBar untuk navigasi antar layar.
 */
@Composable
fun MainScreen() {
    // Inisialisasi NavController untuk menangani navigasi antar layar
    // rememberNavController() memastikan NavController tetap ada selama composable berada dalam Composition
    val navController = rememberNavController()
    
    // Scaffold sebagai layout utama yang menyediakan struktur dasar Material Design
    // termasuk AppBar, BottomAppBar, FloatingActionButton, dll.
    Scaffold(
        // Bottom Navigation Bar
        bottomBar = {
            // BottomAppBar untuk menampilkan navigasi bawah
            BottomAppBar(
                // Styling untuk bottom bar
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                // ===== Tombol Daftar =====
                IconButton(
                    // Aksi saat tombol diklik
                    onClick = { 
                        // Navigasi ke layar Daftar
                        navController.navigate(Screen.List.route) 
                    },
                    // Mengatur ukuran tombol agar sama rata
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Ikon untuk tombol Daftar
                        Icon(
                            painter = painterResource(id = R.drawable.list),
                            contentDescription = "List",  // Penting untuk aksesibilitas
                            modifier = Modifier.size(24.dp)
                        )
                        // Label untuk tombol
                        Text("List", style = MaterialTheme.typography.labelSmall)
                    }
                }
                
                // ===== Tombol Tim =====
                IconButton(
                    onClick = { 
                        // Navigasi ke layar Tim
                        navController.navigate(Screen.Team.route) 
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.team),
                            contentDescription = "Team",
                            modifier = Modifier.size(24.dp)
                        )
                        Text("Team", style = MaterialTheme.typography.labelSmall)
                    }
                }
                
                // ===== Tombol Beranda =====
                IconButton(
                    onClick = { 
                        // Navigasi ke layar Beranda
                        navController.navigate(Screen.Home.route) 
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home",
                            modifier = Modifier.size(24.dp)
                        )
                        Text("Home", style = MaterialTheme.typography.labelSmall)
                    }
                }
                
                // ===== Tombol Event =====
                IconButton(
                    onClick = { 
                        // Navigasi ke layar Event
                        navController.navigate(Screen.Event.route) 
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.event),
                            contentDescription = "Event",
                            modifier = Modifier.size(24.dp)
                        )
                        Text("Event", style = MaterialTheme.typography.labelSmall)
                    }
                }
                
                // ===== Tombol Absen =====
                IconButton(
                    onClick = { 
                        // Navigasi ke layar Absen
                        navController.navigate(Screen.Absen.route) 
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.absen),
                            contentDescription = "Absen",
                            modifier = Modifier.size(24.dp)
                        )
                        Text("Absen", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    ) { innerPadding ->
        // NavHost menangani tampilan layar yang aktif berdasarkan rute saat ini
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,  // Layar yang pertama kali ditampilkan
            modifier = Modifier.padding(innerPadding)  // Menerapkan padding dari Scaffold
        ) {
            // Mendefinisikan semua layar yang dapat dinavigasi
            // Setiap composable di sini akan ditampilkan di area konten utama
            composable(Screen.Home.route) { Greeting("Home") }
            composable(Screen.Absen.route) { Greeting("Absen") }
            composable(Screen.Event.route) { Greeting("Event") }
            composable(Screen.List.route) { Greeting("Daftar") }
            composable(Screen.Team.route) { Greeting("Tim") }
        }
    }
}

/**
 * Komponen sambutan sederhana yang menampilkan nama layar.
 * 
 * @param screenName Nama layar yang akan ditampilkan
 * @param modifier Modifier untuk menyesuaikan tampilan
 */
@Composable
fun Greeting(screenName: String, modifier: Modifier = Modifier) {
    // Column untuk menata konten secara vertikal
    Column(
        modifier = Modifier
            .fillMaxSize()  // Mengisi seluruh ruang yang tersedia
            .padding(16.dp),  // Memberi jarak dari tepi
        verticalArrangement = Arrangement.Center,  // Posisi vertikal di tengah
        horizontalAlignment = Alignment.CenterHorizontally  // Posisi horizontal di tengah
    ) {
        // Menampilkan teks dengan nama layar
        Text(
            text = "Halaman $screenName",
            style = MaterialTheme.typography.headlineMedium,  // Menggunakan gaya teks dari tema
            modifier = modifier
        )
    }
}

/**
 * Preview untuk komponen Greeting.
 * Hanya untuk keperluan pratinjau di Android Studio.
 */
@Preview(showBackground = true)  // Menampilkan latar belakang di preview
@Composable
fun GreetingPreview() {
    // Menerapkan tema yang sama dengan aplikasi
    PTBfixTheme {
        // Menampilkan komponen Greeting dengan teks "Preview"
        Greeting("Preview")
    }
}

/**
 * Activity utama aplikasi.
 * Merupakan titik masuk utama aplikasi Android.
 */
class MainActivity : ComponentActivity() {
    /**
     * Dipanggil saat activity dibuat.
     * 
     * @param savedInstanceState State yang disimpan sebelumnya, null jika tidak ada
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Mengaktifkan edge-to-edge display (konten di belakang system bars)
        enableEdgeToEdge()
        
        // Menetapkan konten UI menggunakan Jetpack Compose
        setContent {
            // Menerapkan tema kustom aplikasi
            PTBfixTheme {
                // Menampilkan layar utama aplikasi
                MainScreen()
            }
        }
    }
}