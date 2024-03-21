package br.com.eventspot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.eventspot.screens.CreateEventScreen
import br.com.eventspot.screens.CreateUserCard
import br.com.eventspot.screens.CreateUserScreen
import br.com.eventspot.screens.HomeScreen
import br.com.eventspot.screens.LoginScreen
import br.com.eventspot.ui.theme.EventSpotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventSpotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
//
                        composable(route = "home") {
                            HomeScreen(navController)
                        }

                        composable(route = "create-user") {
                            CreateUserScreen(navController)
                        }

                        composable(route = "create-event") {
                            CreateEventScreen(navController)
                        }
//                       
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventSpotTheme {
        Greeting("Android")
    }
}}