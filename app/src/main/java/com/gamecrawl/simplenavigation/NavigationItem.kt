package com.gamecrawl.simplenavigation

//create a sealed class for routing for home and details page
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem("home")
    object Details : NavigationItem("details/{name}")
}
