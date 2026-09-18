package pe.edu.upc.easyvet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.edu.upc.easyvet.features.catalog.presentation.navigation.HomeRoute
import pe.edu.upc.easyvet.features.catalog.presentation.navigation.catalogNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeRoute) {
        catalogNavGraph(navController)
    }
}