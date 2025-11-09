package com.example.ptbfix.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ptbfix.R
import com.example.ptbfix.ui.theme.PTBfixTheme

data class Event(
    val id: Int,
    val title: String,
    val date: String,
    val location: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Event") },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.event),
                        contentDescription = "Event",
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
            Text("Welcome Halaman Event")
        }
    }
}

@Composable
fun EventItem(event: Event) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = event.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text("📅 ${event.date}")
            Text("📍 ${event.location}")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EventScreenPreview() {
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EventScreen()
        }
    }
}
