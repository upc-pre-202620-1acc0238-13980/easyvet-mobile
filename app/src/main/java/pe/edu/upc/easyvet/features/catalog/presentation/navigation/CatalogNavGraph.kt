package pe.edu.upc.easyvet.features.catalog.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import pe.edu.upc.easyvet.features.catalog.presentation.home.HomeScreen
import pe.edu.upc.easyvet.features.catalog.presentation.productdetail.ProductDetailScreen

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