package com.example.jagorevamp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jagorevamp.ui.screen.BerandaScreen
import com.example.jagorevamp.ui.screen.KantongScreen
import com.example.jagorevamp.ui.screen.KartuScreen
import com.example.jagorevamp.ui.screen.LainnyaScreen
import com.example.jagorevamp.ui.screen.TransaksiScreen
import com.example.jagorevamp.ui.screen.buatKartuDebit.*

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Beranda.route,
        modifier = Modifier
            .semantics {
                isTraversalGroup = true
                traversalIndex = 1f
            }
    ) {
        composable(
            route = BottomNavItem.Beranda.route + "?fromBottomBar={fromBottomBar}",
            arguments = listOf(navArgument("fromBottomBar") { defaultValue = "false" })
        ) { backStackEntry ->
            val fromBottomBar = backStackEntry.arguments?.getString("fromBottomBar") == "true"
            BerandaScreen(fromBottomBar = fromBottomBar)
        }

        composable(
            route = BottomNavItem.Kantong.route + "?fromBottomBar={fromBottomBar}",
            arguments = listOf(navArgument("fromBottomBar") { defaultValue = "false" })
        ) { backStackEntry ->
            KantongScreen(fromBottomBar = backStackEntry.arguments?.getString("fromBottomBar") == "true")
        }

        composable(
            route = BottomNavItem.Transaksi.route + "?fromBottomBar={fromBottomBar}",
            arguments = listOf(navArgument("fromBottomBar") { defaultValue = "false" })
        ) { backStackEntry ->
            TransaksiScreen(fromBottomBar = backStackEntry.arguments?.getString("fromBottomBar") == "true")
        }

        composable(
            route = BottomNavItem.Kartu.route + "?fromBottomBar={fromBottomBar}",
            arguments = listOf(navArgument("fromBottomBar") { defaultValue = "false" })
        ) { backStackEntry ->
            KartuScreen(navController, fromBottomBar = backStackEntry.arguments?.getString("fromBottomBar") == "true")
        }

        composable(
            route = BottomNavItem.Lainnya.route + "?fromBottomBar={fromBottomBar}",
            arguments = listOf(navArgument("fromBottomBar") { defaultValue = "false" })
        ) { backStackEntry ->
            LainnyaScreen(fromBottomBar = backStackEntry.arguments?.getString("fromBottomBar") == "true")
        }

        composable("PersonalisasiKartuScreen") { PersonalisasiKartuScreen(navController) }
        composable("HubungkanKartuScreen") { HubungkanKartuScreen(navController) }
        composable("IdentitasKartuScreen") { IdentitasKartuScreen(navController) }
        composable("PreviewKartuScreen") { PreviewKartuScreen(navController) }
        composable("KartuDiaktifkanScreen") { KartuDiaktifkanScreen(navController) }
    }
}
