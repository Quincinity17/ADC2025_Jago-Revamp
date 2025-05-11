package com.example.jagorevamp.ui.screen.buatKartuDebit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jagorevamp.R
import com.example.jagorevamp.ui.theme.LocalAppColors

@Composable
fun KartuDiaktifkanScreen(
    navController: NavHostController
) {
    val appColors = LocalAppColors.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(appColors.netral_primaryBG)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                    ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ilt_card_activation_decorative),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Konten dengan padding
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text("Kartu berhasil diaktifkan!", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(
                    "Yuk, atur kartumu dan sesuaikan dengan kebutuhanmu!",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, appColors.primer_default, RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        "Aktifkan dan non-aktifkan fitur ini sesukamu",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_limit_online),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text("Limit Online hingga")
                            Text("Rp50.000.000", fontSize = 12.sp, color = Color.Gray)
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 12.dp),
                        thickness = 1.dp,
                        color = Color.LightGray
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_payment_international),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Lakukan Pembayaran Internasional")
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = appColors.primer_default)
                ) {
                    Text("Atur penggunaan kartu")
                }

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = appColors.primer_default),
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp)
                ) {
                    Text("Lihat Rincian Kartu")
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewKartuDiaktifkanScreen() {
    // Jika kamu punya Theme, bungkus dengan theme-mu:
    // MyAppTheme {
    KartuDiaktifkanScreen(
        navController = rememberNavController()
    )
    // }
}

