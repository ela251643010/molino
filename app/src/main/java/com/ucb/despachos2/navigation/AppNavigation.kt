package com.ucb.despachos2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.despachos2.presentation.EntregasScreen.EntregaUi

import com.ucb.despachos2.presentation.login.LoginUi
import com.ucb.despachos2.presentation.HomeScreen.HomeScreenUI
import com.ucb.despachos2.presentation.ProduPorTraScreen.ProduPorTraUi

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(Screen.LoginScreen.route) {
            LoginUi(navController = navController)
        }

        composable(Screen.HomeScreen.route) {
            HomeScreenUI()
        }
        composable(Screen.EntregasScreen.route)
        {
            backStackEntry ->
            EntregaUi(backStackEntry)
        }
        composable(Screen.ProduccionPorTransporteScren.route)
        {
            ProduPorTraUi()
        }
    }
}
