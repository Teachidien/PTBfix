package com.example.ptbfix.ui.screens

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamScreen() {
    PTBfixTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Tim") },
                    navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.team),
                            contentDescription = "Tim",
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
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.team),
                        contentDescription = "Tim",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Welcome Halaman Tim")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TeamScreenPreview() {
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TeamScreen()
        }
    }
}
