package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.midterm.ui.screen.AddStudentScreen
import com.example.midterm.ui.screen.DashboardScreen
import com.example.midterm.ui.screen.LoginScreen
import com.example.midterm.ui.theme.MidtermTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidtermTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

object NavRoutes {
    const val LOGIN = "login_screen"
    const val DASHBOARD = "dashboard_screen"
    const val EDIT = "edit_screen"
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val navigationController = rememberNavController()

    Surface(modifier) {
        NavHost(
            navController = navigationController,
            startDestination = NavRoutes.LOGIN
        ) {
            composable(NavRoutes.LOGIN) {
                LoginScreen(navController = navigationController, viewModel = viewModel())
            }

            composable(NavRoutes.DASHBOARD){
                DashboardScreen(navController = navigationController)
            }

            composable(NavRoutes.EDIT){
                AddStudentScreen(navController = navigationController)
            }
        }
    }
}

@Preview
@Composable
fun MyAppPreview() {
    MidtermTheme {
        MyApp(Modifier.fillMaxSize())
    }
}
