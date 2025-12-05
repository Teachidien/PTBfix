package com.example.ptbfix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ptbfix.R
import com.example.ptbfix.data.local.Atlet
import com.example.ptbfix.ui.components.AddAtletDialog
import com.example.ptbfix.ui.components.AppTopBar
import com.example.ptbfix.ui.components.AtletList
import com.example.ptbfix.ui.components.EditAtletDialog
import com.example.ptbfix.ui.theme.PTBfixTheme
import com.example.ptbfix.ui.viewmodel.AtletViewModel

// File ini berisi implementasi layar Daftar (ListScreen)
// yang menampilkan daftar atlet dan pengurus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    atletViewModel: AtletViewModel = hiltViewModel()
) {
    // State untuk dialog tambah atlet
    var showAddDialog by remember { mutableStateOf(false) }
    
    // State untuk dialog edit atlet
    var showEditDialog by remember { mutableStateOf(false) }
    var selectedAtlet by remember { mutableStateOf<Atlet?>(null) }
    
    // Mengumpulkan state dari ViewModel
    val atlets by atletViewModel.atlets.collectAsState()
    val isLoading by atletViewModel.isLoading.collectAsState()
    
    // State untuk toggle antara Atlet dan Pengurus
    var showAtlet by remember { mutableStateOf(true) }
    
    // Scaffold sebagai layout utama yang menyediakan struktur dasar Material Design
    // termasuk AppBar, FloatingActionButton, dll.
    Scaffold(
        // AppBar di bagian atas layar
        topBar = {
            AppTopBar(title = if (showAtlet) "Daftar Atlet" else "Daftar Pengurus")  // Title dinamis
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding) // Tambahkan padding dari Scaffold
        ) {
            // Header dengan tombol toggle
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tombol Atlet
                Button(
                    onClick = { showAtlet = true },
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
                
                Spacer(modifier = Modifier.width(8.dp))
                
                // Tombol Pengurus
                Button(
                    onClick = { showAtlet = false },
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

            // Menampilkan konten berdasarkan state yang aktif
            if (showAtlet) {
                // Tombol Tambah Atlet kecil di kiri
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Button(
                        onClick = { 
                            showAddDialog = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.tambah),
                            contentDescription = "Tambah Atlet",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Tambah", fontSize = 12.sp)
                    }
                }
                
                // Menampilkan daftar atlet
                AtletList(
                    atlets = atlets,
                    isLoading = isLoading,
                    onDeleteAtlet = { atlet ->
                        atletViewModel.deleteAtlet(atlet)
                    },
                    onEditAtlet = { atlet ->
                        selectedAtlet = atlet
                        showEditDialog = true
                    }
                )
            } else {
                // Menampilkan teks Daftar Pengurus
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Daftar Pengurus",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                }
            }
        }
        
        // Dialog tambah atlet
        if (showAddDialog) {
            AddAtletDialog(
                onDismiss = { showAddDialog = false },
                onAddAtlet = { newAtlet ->
                    atletViewModel.insertAtlet(newAtlet)
                    showAddDialog = false
                }
            )
        }
        
        // Dialog edit atlet
        if (showEditDialog && selectedAtlet != null) {
            EditAtletDialog(
                atlet = selectedAtlet!!,
                onDismiss = { 
                    showEditDialog = false
                    selectedAtlet = null
                },
                onUpdateAtlet = { updatedAtlet ->
                    atletViewModel.updateAtlet(updatedAtlet)
                    showEditDialog = false
                    selectedAtlet = null
                },
                checkNimExists = { newNim, currentNim ->
                    atletViewModel.checkNimExists(newNim, currentNim)
                }
            )
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
