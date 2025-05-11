package com.example.jagorevamp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.example.jagorevamp.ui.theme.LocalAppColors
import kotlinx.coroutines.delay

@Composable
fun TransaksiScreen(fromBottomBar: Boolean) {
    val appColors = LocalAppColors.current
    val focusRequester = remember { androidx.compose.ui.focus.FocusRequester() }

    LaunchedEffect(fromBottomBar) {
        if (fromBottomBar) {
            delay(200)
            focusRequester.requestFocus()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(appColors.netral_primaryBG)
            .padding(horizontal = 24.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Halaman Transaksi",
            modifier = Modifier
                .focusRequester(focusRequester)
                .focusable()
        )
    }
}

