package pe.edu.upc.easyvet.features.cart.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import pe.edu.upc.easyvet.features.cart.presentation.cart.CartScreen

@Serializable
data object CartNavGraphRoute

@Serializable
data object CartRoute


fun NavGraphBuilder.cartNavGraph(navController: NavController){


    navigation<CartNavGraphRoute>(startDestination = CartRoute) {
        composable<CartRoute> {
            CartScreen()
        }
    }
}