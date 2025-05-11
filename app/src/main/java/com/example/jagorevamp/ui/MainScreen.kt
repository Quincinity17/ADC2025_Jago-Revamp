package com.example.jagorevamp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MainScreen (){
    val bottomBarFocusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        delay(500)
        bottomBarFocusRequester.requestFocus()
    }

    val navController = rememberNavController()
        Scaffold (
            bottomBar = {
                BottomBar(
                navController,
                bottomBarFocusRequester
            ) }

        ) {
            NavigationGraph(navController)
    }

}