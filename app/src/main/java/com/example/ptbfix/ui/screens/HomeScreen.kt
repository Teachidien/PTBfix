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
import com.example.ptbfix.ui.components.AppTopBar
import com.example.ptbfix.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
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
                    // 75% bawah berwarna putih
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .background(Color.White)
                    )
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
                    // 75% bawah berwarna putih
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .background(Color.White)
                    )
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
