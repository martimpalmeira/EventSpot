package br.com.eventspot.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CreateEventScreen(navController: NavController) {
    val offset = Offset(2.0f, 2.0f)
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.White)) {
            append("Cadastrar ")
        }
        withStyle(
            style = SpanStyle(
                color = Color(0xFF7603CB),
            )
        ) {
            append("Evento")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .blur(radius = 10.dp)
            .background(Color(0xFF2C2C2C))
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 16.dp),
            style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold),


            )

        CreateEventCard()



    }
}

@Composable
fun CreateEventCard() {
    val offset = Offset(1.0f, 1.0f)

    Card(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(alpha = 0.2f),
        ),

        ) {
        Column(
            modifier = Modifier
                .padding(bottom = 32.dp, start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLeadingIconColor = Color.White,


                    ),
                value = "",
                onValueChange = {},
                label = { Text("Nome") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp),

                )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLeadingIconColor = Color.White
                ),
                value = "",
                onValueChange = {},
                label = { Text("Descrição") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                minLines = 4

                )


            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLeadingIconColor = Color.White
                ),
                value = "",
                onValueChange = {},
                label = { Text("Data do início") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp),

                )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLeadingIconColor = Color.White
                ),
                value = "",
                onValueChange = {},
                label = { Text("Data do fim") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp),

                )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLeadingIconColor = Color.White
                ),
                value = "",
                onValueChange = {},
                label = { Text("Localização") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp),

                )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* TODO: Implement login logic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),

                colors = ButtonDefaults.buttonColors(Color(0xFF7603CB)),
                shape = RoundedCornerShape(20),


                ) {
                Text(
                    "Salvar",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                )
            }




        }
    }
}



