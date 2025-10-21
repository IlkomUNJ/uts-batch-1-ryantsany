package com.example.midterm.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.midterm.NavRoutes
import com.example.midterm.ui.theme.MidtermTheme
import kotlin.collections.mutableListOf

data class StudentInformation (
    var id: String,
    var name: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(modifier: Modifier = Modifier, navController: NavController) {
    val dummy_data = remember {
        mutableStateListOf(
            StudentInformation(id = "1313623001", name = "Student 1"),
            StudentInformation(id = "1313623002", name = "Student 2"),
            StudentInformation(id = "1313623003", name = "Student 3"),
        )
    }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Student Roster"
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton (
                onClick = { navController.navigate(NavRoutes.EDIT) },
                containerColor = Color.LightGray,
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add student",
                    )
                }
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
            LazyColumn (
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(top = 20.dp)
            ) {
                items(dummy_data) { student ->
                    StudentCard(student.id, student.name)
                }
            }
        }
    )
}

@Composable
fun StudentCard(id: String, username: String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp, start = 20.dp, end = 20.dp)
            .border(1.dp, Color.Black),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(5.dp)
        ) {
            Text(
                text = id
            )
            Text(
                text = username
            )
        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    MidtermTheme {
        DashboardScreen(Modifier.fillMaxSize(), rememberNavController())
    }
}