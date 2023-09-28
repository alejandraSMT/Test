package com.example.test

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.test.screens.BookmarkScreen
import com.example.test.screens.HomeScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            HomeScreen()
        }

        composable("bookmark"){
            BookmarkScreen()
        }
    }

}