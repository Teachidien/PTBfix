package com.example.ptbfix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ptbfix.data.local.Event
import com.example.ptbfix.ui.components.AppTopBar
import com.example.ptbfix.ui.theme.*
import com.example.ptbfix.ui.utils.calculateDaysUntil
import com.example.ptbfix.ui.utils.findNearestEvent
import com.example.ptbfix.ui.viewmodel.EventViewModel
import com.example.ptbfix.ui.viewmodel.AtletViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    eventViewModel: EventViewModel = hiltViewModel(),
    atletViewModel: AtletViewModel = hiltViewModel()
) {
    val events by eventViewModel.events.collectAsState()
    val nearestEvent = remember(events) { findNearestEvent(events) }
    val atlets by atletViewModel.atlets.collectAsState()
    Scaffold(
        topBar = {
            AppTopBar(title = "Beranda")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Baris pertama
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Kotak 1
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                ) {
                    // 25% atas berwarna biru dengan teks
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                            .background(Color(0xFF2196F3)), // Warna biru
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Jumlah Atlet",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    // 75% bawah berwarna putih dengan jumlah atlet
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${atlets.size}",
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2196F3),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                
                // Kotak 2
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                ) {
                    // 25% atas berwarna biru dengan teks
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                            .background(Color(0xFF2196F3)), // Warna biru
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Jumlah Pengurus",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    // 75% bawah berwarna putih
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .background(Color.White)
                    )
                }
            }
            
            // Baris kedua
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Kotak 3
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                ) {
                    // 25% atas berwarna biru dengan teks
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                            .background(Color(0xFF2196F3)), // Warna biru
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Jumlah Team",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    // 75% bawah berwarna putih
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .background(Color.White)
                    )
                }
                
                // Kotak 4
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                ) {
                    // 25% atas berwarna biru dengan teks
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                            .background(Color(0xFF2196F3)), // Warna biru
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Event Terdekat",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    // 75% bawah berwarna putih dengan event info
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        if (nearestEvent != null) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = nearestEvent.namaEvent,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1976D2),
                                    textAlign = TextAlign.Center,
                                    maxLines = 2
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = nearestEvent.tanggalEvent,
                                    fontSize = 10.sp,
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = calculateDaysUntil(nearestEvent.tanggalEvent),
                                    fontSize = 10.sp,
                                    color = Color(0xFF2196F3),
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        } else {
                            Text(
                                text = "Belum ada\nevent\nterdekat",
                                fontSize = 10.sp,
                                color = Color.Gray,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            HomeScreen()
        }
    }
}
