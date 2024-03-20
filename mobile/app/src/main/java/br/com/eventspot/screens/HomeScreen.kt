package br.com.eventspot.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Definindo um modelo de dados para representar um evento
data class Event(
    val name: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val location: String,
    val participants: List<String>
)

// Função de exemplo que retorna uma lista de eventos
fun getSampleEvents(): List<Event> {
    return listOf(
        Event(
            "Evento 1",
            "Descrição do Evento 1",
            "01/01/2023",
            "03/01/2023",
            "Localização do Evento 1",
            listOf("Participante 1", "Participante 2")
        ),
        Event(
            "Evento 2",
            "Descrição do Evento 2",
            "05/01/2023",
            "07/01/2023",
            "Localização do Evento 2",
            listOf("Participante 3", "Participante 4")
        )
    )
}

@Composable
fun HomeScreen(navController: NavController) {
    val events = getSampleEvents()

    Scaffold(
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(events) { event ->
                    EventCard(event)
                }
            }
        }
    )
}

@Composable
fun EventCard(event: Event) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Nome: ${event.name}")
            Text(text = "Descrição: ${event.description}")
            Text(text = "Data de Início: ${event.startDate}")
            Text(text = "Data de Fim: ${event.endDate}")
            Text(text = "Localização: ${event.location}")
            Text(text = "Participantes: ${event.participants.joinToString(", ")}")
        }
    }
}