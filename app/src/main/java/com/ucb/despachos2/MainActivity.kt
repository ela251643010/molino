package com.ucb.despachos2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ucb.despachos2.navigation.AppNavigation
import com.ucb.despachos2.ui.theme.Despachos2Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //throw RuntimeException("Esto es una prueba")
        enableEdgeToEdge()
        setContent {

            Despachos2Theme {
                //Log.d("llegue aca?")
                AppNavigation()
            }
        }
    }

}


//
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Despachos2Theme {
        Greeting("Android")
    }
}