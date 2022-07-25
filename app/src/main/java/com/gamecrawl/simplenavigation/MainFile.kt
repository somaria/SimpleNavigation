package com.gamecrawl.simplenavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Details.route) {
            val name = it.arguments?.getString("name")
            if (name != null) {
                DetailsScreen(navController, name = name)
            }
        }
    }

}

@Composable
fun HomeScreen(navController: NavHostController) {

    val dummyValue = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            TextField(value = dummyValue.value, onValueChange = {
                dummyValue.value = it
            })
            Button(onClick = { navController.navigate("details/${dummyValue.value}") }) {
                Text("Go to Second Screen")
            }
        }
    }
}

//Create the details screen
@Composable
fun DetailsScreen(navController: NavHostController, name: String) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Details Screen")
            Text("Name: $name")
//pop off controller
            Button(onClick = { navController.popBackStack() }) {
                Text("Go back")
            }
        }
    }
}
