package com.example.jagorevamp.ui

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jagorevamp.ui.theme.LocalAppColors

@Composable
fun BottomBar(
    navController: NavHostController,
    focusRequester: FocusRequester
) {
    val items = listOf(
        BottomNavItem.Beranda,
        BottomNavItem.Kantong,
        BottomNavItem.Transaksi,
        BottomNavItem.Kartu,
        BottomNavItem.Lainnya
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isInBottomNav = items.any { it.route in currentRoute.orEmpty() }
    val appColors = LocalAppColors.current

    if (isInBottomNav) {
        NavigationBar(
            modifier = Modifier.semantics {
                isTraversalGroup = true
            },
            containerColor = appColors.netral_primaryBG
        ) {
            Row(Modifier.fillMaxWidth()) {
                items.forEachIndexed { index, item ->
                    val selected = currentRoute?.startsWith(item.route) == true
                    val iconRes = if (selected) item.iconActive else item.iconInactive

                    val modifier = Modifier
                        .weight(1f)
                        .then(
                            if (index == 0) {
                                Modifier
                                    .focusRequester(focusRequester)
                                    .semantics { traversalIndex = -1f }
                            } else {
                                Modifier.semantics { traversalIndex = index.toFloat() }
                            }
                        )

                    CustomNavigationBarItem(
                        iconRes = iconRes,
                        label = item.label,
                        selected = selected,
                        modifier = modifier,
                        onClick = {
                            if (!selected) {
                                navController.navigate("${item.route}?fromBottomBar=true") {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
