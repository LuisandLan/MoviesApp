package com.bignerdranch.android.moviesapp.navigation

import android.os.Build
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bignerdranch.android.moviesapp.MainViewModel
import com.bignerdranch.android.moviesapp.screens.DetailsScreen
import com.bignerdranch.android.moviesapp.screens.MainScreen
import com.bignerdranch.android.moviesapp.screens.SplashScreen
import com.bignerdranch.android.moviesapp.utils.Constants

sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)


}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Details.route + "/{id}") { navBackStackEntry ->
            DetailsScreen( viewModel =viewModel, itemId =navBackStackEntry.arguments?.getString("Id")?:"1")

        }
    }
}