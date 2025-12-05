package com.example.ptbfix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ptbfix.data.api.RetrofitClient
import com.example.ptbfix.navigation.Screen
import com.example.ptbfix.ui.theme.PTBfixTheme
import com.example.ptbfix.ui.screens.AbsenScreen
import com.example.ptbfix.ui.screens.EventScreen
import com.example.ptbfix.ui.screens.HomeScreen
import com.example.ptbfix.ui.screens.ListScreen
import com.example.ptbfix.ui.screens.TeamScreen
import android.util.Log
import kotlinx.coroutines.launch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
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
        // Menggunakan NavHost untuk menangani navigasi antar layar
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Mendefinisikan rute untuk setiap layar
            composable(Screen.Home.route) { 
                HomeScreen()
            }
            composable(Screen.List.route) { 
                ListScreen()
            }
            composable(Screen.Team.route) { 
                TeamScreen()
            }
            composable(Screen.Event.route) { 
                EventScreen()
            }
            composable(Screen.Absen.route) { 
                AbsenScreen()
            }
        }
    }
    val scope = rememberCoroutineScope()
    var serverMessage by remember { mutableStateOf(" ") }

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                val response = RetrofitClient.apiService.testConnection()
                if (response.isSuccessful) {
                    val message = response.body()?.message ?: "Tidak ada pesan"
                    serverMessage = "Terhubung ke server: $message"
                    Log.d("SERVER_TEST", "Success: $message")
                } else {
                    serverMessage = "Gagal: ${response.code()}"
                    Log.e("SERVER_TEST", "Error: ${response.code()}")
                }
            } catch (e: Exception) {
               // serverMessage = "Koneksi gagal: ${e.message}"
               // Log.e("SERVER_TEST", "Exception: ${e.message}")
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = serverMessage, style = MaterialTheme.typography.titleMedium)
    }
}