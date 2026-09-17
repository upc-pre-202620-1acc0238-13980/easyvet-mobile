package pe.edu.upc.easyvet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.upc.easyvet.core.theme.EasyVetTheme
import pe.edu.upc.easyvet.features.catalog.presentation.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EasyVetTheme(dynamicColor = false) {
                HomeScreen()
            }
        }
    }
}