package com.example.jagorevamp.ui.screen.buatKartuDebit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jagorevamp.R
import com.example.jagorevamp.ui.theme.*

@Composable
fun PersonalisasiKartuScreen(
    navController: NavHostController
) {
    val formFocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val appColors = LocalAppColors.current
    var namaKartu by remember { mutableStateOf(TextFieldValue("")) }
    var selectedCardType by remember { mutableStateOf("digital") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(appColors.netral_primaryBG)
            .padding( vertical = 48.dp)
    ) {
        // Top Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 12.dp)
            ) {
            IconButton(onClick = { navController.popBackStack() },) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali ke halaman kartu",
                    modifier = Modifier
                        .size(32.dp)
                        .semantics { traversalIndex = 0f }
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Buat Kartu Debit",
                style = TitleM,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Konten utama
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)) {
            // Judul
            Text(
                "Personalisasikan Kartumu",
                style = HeadingLB,
                modifier = Modifier
                    .semantics {
                        heading()
//                        traversalIndex = 1f
                    }

            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Silakan buat nama kartu dan pilih jenis kartu yang sesuai dengan kebutuhanmu.",
                style = BodySM,
                modifier = Modifier
//                    .semantics { traversalIndex = 2f }

            )

            Spacer(modifier = Modifier.height(24.dp))

            // Input Nama Kartu
            Text(
                "Nama kartu di aplikasi",
                style = HeadingMB,
                modifier = Modifier
                    .semantics {
                        heading()
//                        traversalIndex = 3f
                    }


            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(appColors.info_base)
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(appColors.info_default),
                    modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Nama tidak akan dicetak pada kartu.",
                    style = CaptionM,
                    modifier = Modifier
                        .semantics {
//                            traversalIndex = 4f
                        }

                )
            }


                OutlinedTextField(
                    value = namaKartu,
                    onValueChange = { if (it.text.length <= 30) namaKartu = it },
                    placeholder = { Text("contoh, Kartu Jajan") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clearAndSetSemantics  {
                            contentDescription = "Nama kartu di aplikasi, hanya huruf dan angka yang diperbolehkan.Diisi ${namaKartu.text.length} dari 30 karakter"
                        },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (namaKartu.text.isNotEmpty()) appColors.yellow_base else appColors.netral_generalFont,
                        unfocusedBorderColor = if (namaKartu.text.isNotEmpty()) appColors.yellow_base else appColors.netral_generalFont,
                        cursorColor = appColors.primer_default,
                        focusedLabelColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { formFocusRequester.requestFocus() }
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clearAndSetSemantics { }
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Hanya huruf dan angka yang diperbolehkan.",
                        style = CaptionM
                    )
                    Text(
                        text = "${namaKartu.text.length}/30",
                        style = CaptionM
                    )
                }



            Spacer(modifier = Modifier.height(24.dp))

            // Tipe Kartu
            Text(
                "Tipe Kartu",
                style = HeadingMB,
                modifier = Modifier
                    .semantics { heading() }
                    .focusRequester(formFocusRequester),
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Digital Card
            CardOption(
                title = "Kartu Digital Jago",
                description = listOf(
                    "Kartu kamu tidak akan hilang",
                    "Proses aktivasi yang instan",
                    "Tidak dapat kartu fisik"
                ),
                icon = painterResource(id = R.drawable.ic_card_digital),
                selected = selectedCardType == "digital",
                onClick = { selectedCardType = "digital" },
                borderColor = appColors.primer_default
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Fisik Card
            CardOption(
                title = "Kartu Fisik Jago",
                description = listOf(
                    "Bertransaksi offline dan online di mana pun",
                    "Penarikan tunai di semua ATM",
                    "Kartu akan dikirim ke alamatmu"
                ),
                icon = painterResource(id = R.drawable.ic_card_physical),
                selected = selectedCardType == "fisik",
                onClick = { selectedCardType = "fisik" },
                borderColor = appColors.primer_default
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("HubungkanKartuScreen") },
            enabled = namaKartu.text.isNotBlank(),
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
fun CardOption(
    title: String,
    description: List<String>,
    icon: Painter,
    selected: Boolean,
    onClick: () -> Unit,
    borderColor: Color
) {
    val appColors = LocalAppColors.current

    val border = if (selected) borderColor else Color.Gray.copy(alpha = 0.3f)
    val bgColor = if (selected) borderColor.copy(alpha = 0.05f) else Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor, shape = RoundedCornerShape(12.dp))
            .border(2.dp, border, RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .clearAndSetSemantics {
                contentDescription = buildString {
                    append(title)
                    if (selected) append(", dipilih") else append(", tidak dipilih")
                    append(". ")
                    append(description.joinToString(". "))                }
                role = Role.RadioButton
            },
        verticalAlignment = Alignment.Top
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = appColors.primer_default,
                unselectedColor = appColors.netral_helperFont
            ),
            modifier = Modifier.clearAndSetSemantics { }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 18.dp)
                .clearAndSetSemantics { }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            ) {
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    title,
                    style = BodyMM
                )
            }
            description.forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_bullet_point),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .padding(start = 6.dp, end = 16.dp)
                            .size(14.dp)
                    )
                    Text(
                        it,
                        style = CaptionM
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonalisasiKartuScreenPreview() {
    val dummyNavController = rememberNavController()
    PersonalisasiKartuScreen(navController = dummyNavController)
}