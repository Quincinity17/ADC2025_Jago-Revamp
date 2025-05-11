package com.example.jagorevamp.ui.screen.buatKartuDebit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jagorevamp.R
import com.example.jagorevamp.ui.theme.BodyLM
import com.example.jagorevamp.ui.theme.BodyMM
import com.example.jagorevamp.ui.theme.BodySB
import com.example.jagorevamp.ui.theme.BodySM
import com.example.jagorevamp.ui.theme.CaptionB
import com.example.jagorevamp.ui.theme.HeadingLB
import com.example.jagorevamp.ui.theme.LocalAppColors
import com.example.jagorevamp.ui.theme.TitleM

@Composable
fun HubungkanKartuScreen(navController: NavHostController) {
    val appColors = LocalAppColors.current
    var selectedOption by remember { mutableStateOf("baru") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(appColors.netral_primaryBG)
            .padding( vertical = 48.dp)
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 24.dp),

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(32.dp)
                            .semantics { traversalIndex = 0f }

                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Buat Kartu Digital",
                    style = TitleM
                )
            }
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
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Konten dibungkus dalam Column
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)) {
            Text(
                "Hubungkan kartu ini ke Kantong",
                style = HeadingLB
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Pilih Kantong atau buat Kantong khusus untuk dihubungkan ke kartu debit kamu. Kartu akan mengambil dana dari Kantong yang kamu pilih.",
                style = BodySM
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Option: Buat Kantong Baru
            KantongOption(
                selected = selectedOption == "baru",
                onClick = { selectedOption = "baru" },
                title = "Buat Kantong baru",
                nameKantong = "Kartu Jajan",
                showEdit = true,
                borderColor = appColors.primer_default
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Option: Pilih dari daftar Kantong
            KantongOption(
                selected = selectedOption == "daftar",
                onClick = { selectedOption = "daftar" },
                title = "Pilih dari daftar Kantong",
                nameKantong="",
                showEdit = false,
                borderColor = appColors.primer_default
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Tombol Lanjut
        Button(
            onClick = { navController.navigate("IdentitasKartuScreen") },
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = appColors.primer_default,
                contentColor = appColors.netral_primaryBG,
                disabledContainerColor = appColors.netral_disabledButton,
                disabledContentColor = appColors.netral_helperFont
            )
        ) {
            Text(
                "Lanjut",
                style = BodyLM
            )
        }
    }
}

@Composable
fun KantongOption(
    selected: Boolean,
    onClick: () -> Unit,
    title: String,
    nameKantong: String,
    showEdit: Boolean,
    borderColor: Color
) {
    val appColors = LocalAppColors.current

    val border = if (selected) borderColor else Color.Gray.copy(alpha = 0.2f)
    val bg = if (selected) borderColor.copy(alpha = 0.05f) else Color.White

    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(bg, shape = RoundedCornerShape(12.dp))
            .border(2.dp, border, RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = appColors.primer_default,
                unselectedColor = appColors.netral_helperFont
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(14.dp))

            Text(
                title,
                style = BodyMM
            )
            if (showEdit) {
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=12.dp)
                        .padding(bottom = 12.dp, end = 12.dp),

                    ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_kantong),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            nameKantong ,
                            style = BodySM
                        )
                    }
                    Text(
                        text = "Ubah",
                        color = appColors.primer_default,
                        modifier = Modifier.padding(end = 4.dp),
                        style = CaptionB.copy(textDecoration = TextDecoration.Underline)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Preview HubungkanKartuScreen")
@Composable
fun PreviewHubungkanKartuScreen() {
    // Pakai dummy NavHostController untuk preview
    val navController = rememberNavController()

    MaterialTheme {
        HubungkanKartuScreen(navController = navController)
    }
}
