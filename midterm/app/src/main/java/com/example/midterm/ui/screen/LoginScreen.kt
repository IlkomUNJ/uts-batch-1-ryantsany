package com.example.midterm.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.midterm.MyApp
import com.example.midterm.ui.theme.MidtermTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Login
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.midterm.NavRoutes
import com.example.midterm.ui.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController, viewModel: LoginViewModel) {
    var usernameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Login")
                },
            )
        },
        content = { innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(vertical = 25.dp, horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    label = { Text("Username") },
                    value = usernameValue,
                    onValueChange = { usernameValue = it },
                    maxLines = 1
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    label = { Text("Password") },
                    value = passwordValue,
                    onValueChange = {passwordValue = it},
                    visualTransformation = PasswordVisualTransformation()

                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    onClick = {
                                    viewModel.login(usernameValue, passwordValue)
                                    if(viewModel.loginState.value.isLoggedIn){
                                        navController.navigate (NavRoutes.DASHBOARD)
                                    }
                              },
                    shape = RoundedCornerShape(2.dp)
                ) {
                    Text("Login")
                }
            }
        }

    )
}

@Preview
@Composable
fun LoginScreenPreview() {
    MidtermTheme {
        LoginScreen(Modifier.fillMaxSize(), rememberNavController(), viewModel())
    }
}