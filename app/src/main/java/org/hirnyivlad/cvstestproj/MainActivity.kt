package org.hirnyivlad.cvstestproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.hirnyivlad.cvstestproj.navigation.NavGraph
import org.hirnyivlad.cvstestproj.ui.theme.CVSTestProjTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CVSTestProjTheme {
                val navHostController: NavHostController = rememberNavController()
                NavGraph(navController = navHostController)
            }
        }
    }
}
