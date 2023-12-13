package com.mak.tvshows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.mak.tvshows.repo.model.ShowResults
import com.mak.tvshows.ui.detail.view.ShowDetail
import com.mak.tvshows.ui.home.view.Home
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavGraph(navController, "home")

        }

    }
}

@Composable
fun NavGraph(navController: NavHostController, startDestination: String = "home") {
    NavHost(navController, startDestination) {
        composable(route = "home") { Home(navController) }

        composable(
            route = "showDetail/{showJson}",
            arguments = listOf(
                navArgument("showJson") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            val showJson = backStackEntry.arguments?.getString("showJson")

            val item = Gson().fromJson(showJson, ShowResults::class.java)

            ShowDetail(navController, item)
        }
    }
}