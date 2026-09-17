package pe.edu.upc.easyvet.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.edu.upc.easyvet.features.catalog.presentation.catalogNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        catalogNavGraph(navController)
    }
}