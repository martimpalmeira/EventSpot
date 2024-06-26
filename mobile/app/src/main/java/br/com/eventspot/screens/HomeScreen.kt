package br.com.eventspot.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

fun getSampleEvents(): List<Event> {
    return listOf(
        Event(
            "Festival de Cinema Internacional",
            "O Festival de Cinema Internacional apresenta uma seleção de filmes premiados e produções independentes de todo o mundo.",
            "10/05/2024",
            "15/05/2024",
            "Cineplex Downtown, Nova York",
            listOf("John Smith", "Emily Johnson", "Michael Brown")
        ), Event(
            "Expedição de Trilha na Montanha",
            "Junte-se a nós para uma emocionante expedição de trilha na montanha, explorando vistas deslumbrantes e paisagens naturais.",
            "20/06/2024",
            "22/06/2024",
            "Trilha da Montanha Verde, Colorado",
            listOf("Sophia Martinez", "David Wilson", "Maria Garcia")
        ), Event(
            "Festival Gastronômico Local",
            "Experimente uma deliciosa variedade de pratos locais, desde pratos tradicionais até culinária internacional.",
            "15/07/2024",
            "17/07/2024",
            "Praça da Cidade, São Paulo",
            listOf("Ana Silva", "Lucas Oliveira", "Camila Santos")
        ), Event(
            "Exposição de Arte Contemporânea",
            "Descubra as mais recentes obras de artistas contemporâneos em uma exposição de arte imperdível.",
            "05/08/2024",
            "07/08/2024",
            "Galeria de Arte Moderna, Londres",
            listOf("Emma Thompson", "Daniel Brown", "Sophie Wilson")
        )
    )
}

@Composable
fun HomeScreen(navController: NavController) {
    val events = getSampleEvents()

    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.White)) {
            append("Eventos ")
        }
        withStyle(
            style = SpanStyle(
                color = Color(0xFF7603CB),
            )
        ) {
            append("Disponíveis")
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C2C2C))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(end = 8.dp), // Ajuste a margem para controlar o espaço entre o ícone e o texto
            contentAlignment = Alignment.CenterEnd
        ) {
            IconButton(
                onClick = { navController.navigate("login") }, // Navega para a tela de login
                modifier = Modifier.size(48.dp)

            ) {
                Row ( modifier = Modifier.fillMaxWidth()
                  ){
                    Text(
                        text = "Sair",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    Icon(
                        imageVector = Icons.Filled.ExitToApp,
                        contentDescription = "Logout",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )


                }

            }



            Text(
                text = text,
                modifier = Modifier

                    .padding(vertical = 16.dp),
                style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold),

                )
        }



        Button(
            onClick = { navController.navigate("create-event") },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),

            colors = ButtonDefaults.buttonColors(Color(0xFF7603CB)),
            shape = RoundedCornerShape(20),


            ) {
            Text(
                "Cadastrar Evento", style = TextStyle(
                    fontWeight = FontWeight.Medium, fontSize = 18.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)

        ) {
            items(events) { event ->
                EventCard(event)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }


}

@Composable
fun EventCard(event: Event) {
    Card(
        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(alpha = 0.2f),
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            EventInfo(label = "Nome:", value = event.name)
            EventInfo(label = "Descrição:", value = event.description)
            EventInfo(label = "Data de Início:", value = event.startDate)
            EventInfo(label = "Data de Fim:", value = event.endDate)
            EventInfo(label = "Localização:", value = event.location)
            EventInfo(label = "Participantes:", value = event.participants.joinToString(","))
        }
    }
}

@Composable
fun EventInfo(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.White)
        )
        Text(
            text = value,
            style = TextStyle(fontWeight = FontWeight.Normal, color = Color.White),
            modifier = Modifier.padding(start = 8.dp) // Adiciona espaço entre a label e o valor
        )
    }
}