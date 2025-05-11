package com.example.jagorevamp.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jagorevamp.R
import com.example.jagorevamp.ui.theme.HeadingLB
import com.example.jagorevamp.ui.theme.LocalAppColors
import kotlinx.coroutines.delay
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import com.example.jagorevamp.ui.theme.BodyLB
import com.example.jagorevamp.ui.theme.BodyMM
import com.example.jagorevamp.ui.theme.HeadingMB


@Composable
fun KartuScreen(
    navController: NavHostController,
    fromBottomBar: Boolean
) {
    val appColors = LocalAppColors.current
    val focusRequester = remember { androidx.compose.ui.focus.FocusRequester() }

    LaunchedEffect(fromBottomBar) {
        delay(200)
        Log.d("JusMangga", "Requesting focus...")
        focusRequester.requestFocus()
    }

    Box(modifier = Modifier.fillMaxSize())
    {
        //background
        Image(
            painter = painterResource(id = R.drawable.bg_gradient),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 48.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Kartu",
                    style = HeadingLB,
                    color = Color.Black,
                    modifier = Modifier
                        .focusRequester(focusRequester)
                        .focusable()
                        .semantics { heading() }
                )
                Row {
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .semantics { role = Role.Button}

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_faq),
                            contentDescription = "Frequently Asked Questions",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .semantics { role = Role.Button}
                    ) {
                        Image(
                            Icons.Default.Add,
                            contentDescription = "Add Card",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }

            // Konten utama
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.ilt_wallet_decorative),
                    contentDescription = null,
                    modifier = Modifier
                        .size(380.dp)
                        .padding(bottom = 32.dp)

                )

                Text(
                    text = "Kamu belum mempunyai kartu.",
                    style = HeadingMB,
                    modifier = Modifier.semantics { heading() }


                )
                Text(
                    text = "Yuk, Buat kartu debit untuk kemudahan bertransaksi!",
                    style = BodyMM,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 32.dp)

                )

                Button(
                    onClick = { navController.navigate("PersonalisasiKartuScreen")  },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = appColors.primer_default,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text("Buat Kartu")
                }
            }
        }
    }
}

