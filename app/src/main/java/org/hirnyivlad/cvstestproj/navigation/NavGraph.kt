package org.hirnyivlad.cvstestproj.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import org.hirnyivlad.cvstestproj.presentation.main_screen.MainScreen
import org.hirnyivlad.cvstestproj.presentation.movie_details_screen.MovieDetailsScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(navController = navController)
        }
        composable("details_screen/{id}") {
            MovieDetailsScreen(navController = navController)
        }
    }
}