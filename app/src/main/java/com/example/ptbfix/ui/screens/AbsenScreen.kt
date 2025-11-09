package com.example.ptbfix.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ptbfix.R
import com.example.ptbfix.ui.theme.PTBfixTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbsenScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Absensi") },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.absen),
                        contentDescription = "Absensi",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(24.dp)
                    )
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("Welcome Halaman Absen")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AbsenScreenPreview() {
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AbsenScreen()
        }
    }
}
