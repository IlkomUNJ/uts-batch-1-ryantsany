package com.example.midterm.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.midterm.NavRoutes
import com.example.midterm.ui.theme.MidtermTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudentScreen(modifier: Modifier = Modifier, navController: NavController) {
    var studentId by remember { mutableStateOf("") }
    var studentName by remember { mutableStateOf("") }
    var studentPhone by remember { mutableStateOf("") }
    var studentAddress by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add student"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.navigate(NavRoutes.DASHBOARD) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Black)
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .padding(vertical = 25.dp, horizontal = 20.dp)
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    label = {
                        Text("Student ID")
                    },
                    value = studentId,
                    onValueChange = { it -> studentId = it},
                    maxLines = 1
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    label = {
                        Text("Name")
                    },
                    value = studentName,
                    onValueChange = { it -> studentName = it },
                    maxLines = 1
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    label = {
                        Text("Phone")
                    },
                    value = studentPhone,
                    onValueChange = { it -> studentPhone = it},
                    maxLines = 1
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    label = {
                        Text("Address")
                    },
                    value = studentAddress,
                    onValueChange = { it -> studentAddress = it }
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    onClick = { navController.navigate (NavRoutes.DASHBOARD)},
                    shape = RoundedCornerShape(2.dp)
                ) {
                    Text("Register")
                }
            }
        }
    )
}

@Preview
@Composable
fun AddStudentScreenPreview() {
    MidtermTheme {
        AddStudentScreen(Modifier.fillMaxSize(), rememberNavController())
    }
}