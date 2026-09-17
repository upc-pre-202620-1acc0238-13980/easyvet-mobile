package pe.edu.upc.easyvet.features.catalog.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
data class ProductDetailRoute(val id: Int)

fun NavGraphBuilder.catalogNavGraph(navController: NavController) {

    composable<HomeRoute> {
        HomeScreen { product ->
            navController.navigate(ProductDetailRoute(id = product.id))
        }
    }

    composable<ProductDetailRoute> { backStackEntry ->
        val route: ProductDetailRoute = backStackEntry.toRoute()
        ProductDetailScreen(id = route.id) {
            navController.popBackStack()
        }
    }
}