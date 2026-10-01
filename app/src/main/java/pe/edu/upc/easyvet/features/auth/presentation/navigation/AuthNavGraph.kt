package pe.edu.upc.easyvet.features.auth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import pe.edu.upc.easyvet.features.auth.presentation.login.LoginScreen

@Serializable
data object AuthNavGraphRoute

@Serializable
data object LoginRoute

@Serializable
data object RegisterRoute

fun NavGraphBuilder.authNavGraph(navController: NavController) {

    navigation<AuthNavGraphRoute>(startDestination = LoginRoute) {
        composable<LoginRoute> {
            LoginScreen()
        }

        composable<RegisterRoute> {

        }
    }
}