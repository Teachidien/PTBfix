package com.example.ptbfix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ptbfix.R
import com.example.ptbfix.data.local.Event
import com.example.ptbfix.ui.components.AddEventDialog
import com.example.ptbfix.ui.components.AppTopBar
import com.example.ptbfix.ui.components.EditEventDialog
import com.example.ptbfix.ui.components.EventCard
import com.example.ptbfix.ui.theme.PTBfixTheme
import com.example.ptbfix.ui.viewmodel.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen(
    eventViewModel: EventViewModel = hiltViewModel()
) {
    val events by eventViewModel.events.collectAsState()
    val isLoading by eventViewModel.isLoading.collectAsState()
    
    var showAddDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var selectedEvent by remember { mutableStateOf<Event?>(null) }
    
    Scaffold(
        topBar = {
            AppTopBar(title = "Event")
        },
        floatingActionButton = {
            // Tombol Tambah di pojok kanan bawah
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.tambah),
                    contentDescription = "Tambah Event",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else if (events.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Belum ada event. Klik tombol + untuk menambah event.",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            } else {
                // Tampilkan daftar event di sini
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(events) { event ->
                        EventCard(
                            event = event,
                            onEdit = {
                                selectedEvent = event
                                showEditDialog = true
                            },
                            onDelete = {
                                eventViewModel.deleteEvent(event)
                            }
                        )
                    }
                }
            }
        }
        
        // Dialog tambah event
        if (showAddDialog) {
            AddEventDialog(
                onDismiss = { showAddDialog = false },
                onAddEvent = { newEvent ->
                    eventViewModel.insertEvent(newEvent)
                    showAddDialog = false
                }
            )
        }
        
        // Dialog edit event
        if (showEditDialog && selectedEvent != null) {
            EditEventDialog(
                event = selectedEvent!!,
                onDismiss = { 
                    showEditDialog = false
                    selectedEvent = null
                },
                onUpdateEvent = { updatedEvent ->
                    eventViewModel.updateEvent(updatedEvent)
                    showEditDialog = false
                    selectedEvent = null
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventScreenPreview() {
    PTBfixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            EventScreen()
        }
    }
}
