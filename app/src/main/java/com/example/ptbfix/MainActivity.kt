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
// Import untuk komponen UI dan navigasi
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Import untuk Navigation Component
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// Import komponen kustom
import com.example.ptbfix.navigation.Screen
import com.example.ptbfix.ui.theme.PTBfixTheme

/**
 * Layar utama yang menangani navigasi antar layar
 */
@Composable
fun MainScreen() {
    // Inisialisasi NavController untuk menangani navigasi
    val navController = rememberNavController()
    
    // Scaffold sebagai layout utama dengan bottom navigation
    Scaffold(
        // Bottom Navigation Bar
        bottomBar = {
            BottomAppBar(
                // Styling untuk bottom bar
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                // Tombol untuk menuju ke halaman Daftar
                IconButton(
                    // Aksi saat tombol diklik
                    onClick = { navController.navigate(Screen.List.route) },
                    // Mengatur ukuran tombol agar sama rata
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.list),
                            contentDescription = "List",
                            modifier = Modifier.size(24.dp)
                        )
                        Text("List", style = MaterialTheme.typography.labelSmall)
                    }
                }
                // Team button
                IconButton(
                    onClick = { navController.navigate(Screen.Team.route) },
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
                // Home button
                IconButton(
                    onClick = { navController.navigate(Screen.Home.route) },
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
                // Event button
                IconButton(
                    onClick = { navController.navigate(Screen.Event.route) },
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
                // Absen button
                IconButton(
                    onClick = { navController.navigate(Screen.Absen.route) },
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
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { Greeting("Home") }
            composable(Screen.Absen.route) { Greeting("Absen") }
            composable(Screen.Event.route) { Greeting("Event") }
            composable(Screen.List.route) { Greeting("Daftar") }
            composable(Screen.Team.route) { Greeting("Tim") }
        }
    }
}

@Composable
fun Greeting(screenName: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Halaman $screenName",
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PTBfixTheme {
        Greeting("Preview")
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PTBfixTheme {
                MainScreen()
            }
        }
    }
}