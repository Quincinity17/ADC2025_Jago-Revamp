package com.example.jagorevamp.ui.screen.buatKartuDebit

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jagorevamp.R
import com.example.jagorevamp.ui.theme.BodyLM
import com.example.jagorevamp.ui.theme.BodyMB
import com.example.jagorevamp.ui.theme.BodySM
import com.example.jagorevamp.ui.theme.CaptionB
import com.example.jagorevamp.ui.theme.HeadingLB
import com.example.jagorevamp.ui.theme.HeadingMB
import com.example.jagorevamp.ui.theme.LocalAppColors
import com.example.jagorevamp.ui.theme.TitleM

@Composable
fun PreviewKartuScreen(
    navController: NavHostController
) {
    val appColors = LocalAppColors.current
    var showPreview by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(appColors.netral_primaryBG)
            .padding(vertical = 48.dp),
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 12.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Konfirmasi",
                style = TitleM,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Text(
                "Preview Kartu Digital",
                style = HeadingLB
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.card_preview_informative_on),
                    contentDescription = null,
                    modifier = Modifier.height(170.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_kantong),
                            modifier = Modifier.size(24.dp),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Kartu Jajan",
                            style = BodyMB
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { showPreview = true },
                        colors = ButtonDefaults.buttonColors(containerColor = appColors.primer_default)
                    ) {
                        Text(
                            "Lihat Kartu",
                            style = CaptionB
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                "Biaya",
                style = HeadingMB
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Biaya Pembuatan Kartu",
                    style = BodySM
                )

                Text(
                    "Gratis",
                    style = BodyMB
                )
            }

            Divider(modifier = Modifier.padding(vertical = 12.dp))

            Text(
                "Biaya tambahan akan dibebankan dari Kantong utama kamu.",
                style = BodySM
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("KartuDiaktifkanScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = appColors.primer_default)
        ) {
            Text(
                "Buat Kartu Baru",
                style = BodyLM
            )
        }

        if (showPreview) {
            AlertDialog(
                onDismissRequest = { showPreview = false },
                confirmButton = {
                    Button(
                        onClick = { showPreview = false },
                        colors = ButtonDefaults.buttonColors(containerColor = appColors.primer_default),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {
                        Text("Tutup")
                    }
                },
                text = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.card_preview_informative_off),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(0.95f) // hampir full
                                .aspectRatio(0.63f),

                                    contentScale = ContentScale.Fit
                        )
                    }
                },
                containerColor = Color.Transparent,
                shape = RoundedCornerShape(0.dp),
                tonalElevation = 0.dp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKartuScreenPreview() {
    val dummyNavController = rememberNavController()
    PreviewKartuScreen(navController = dummyNavController)
}