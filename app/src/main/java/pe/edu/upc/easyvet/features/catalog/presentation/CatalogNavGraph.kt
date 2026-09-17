package pe.edu.upc.easyvet.features.catalog.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.catalogNavGraph(navController: NavController) {

    composable("home") {
        HomeScreen()
    }

    composable("product_detail") {
    }
}