package com.example.jagorevamp.ui.screen.buatKartuDebit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jagorevamp.R
import com.example.jagorevamp.ui.theme.BodyLB
import com.example.jagorevamp.ui.theme.BodyLM
import com.example.jagorevamp.ui.theme.HeadingLB
import com.example.jagorevamp.ui.theme.HeadingMB
import com.example.jagorevamp.ui.theme.LocalAppColors
import com.example.jagorevamp.ui.theme.TitleM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdentitasKartuScreen(
    navController: NavHostController
) {
    val appColors = LocalAppColors.current
    var selectedName by remember { mutableStateOf("") }
    val nameOptions = listOf("ALBERT PAIJO", "A PAIJO", "ALBERT P")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(appColors.netral_primaryBG)
            .padding(vertical = 48.dp)
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
                "Buat Kartu Digital",
                style = TitleM,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Konten utama dibungkus dalam Column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)) {
            Text(
                "Beri identitas pada kartumu",
                style = HeadingLB
            )
            Text(
                "Pilih nama kamu untuk ditampilkan pada kartu",
                style = BodyLM,
                modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
            )

            // Dropdown nama
            var expanded by remember { mutableStateOf(false) }
            val orangeStroke = if (selectedName.isBlank()) Color.Gray else Color(0xFFF57C00)
            val purpleHighlight = Color(0xFF9C27B0)

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = selectedName,
                    onValueChange = {},
                    readOnly = true,
                    placeholder = {
                        Text(
                            "Pilih nama",
                            style = BodyLB
                        )
                    },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .border(2.dp, orangeStroke, RoundedCornerShape(12.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp)
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                        .border(width = 2.dp, color = orangeStroke, shape = RoundedCornerShape(12.dp))
                ) {
                    nameOptions.forEach { name ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    name,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (name == selectedName) purpleHighlight else Color.Black
                                )
                            },
                            onClick = {
                                selectedName = name
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Preview Kartu
            Text(
                "Preview Kartu Digital",
                style = HeadingMB
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = if (selectedName.isNotBlank()) painterResource(id = R.drawable.card_preview_informative_off) else painterResource(id = R.drawable.card_preview_informative_on),
                    contentDescription = "Kartu",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Jago Digital Card",
                    style = BodyLB
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Tombol Lanjut
        Button(
            onClick = { navController.navigate("PreviewKartuScreen") },
            enabled = selectedName.isNotBlank(),
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

@Preview(showBackground = true)
@Composable
fun PreviewIdentitasKartuScreen() {
    val dummyNavController = rememberNavController()
    IdentitasKartuScreen(navController = dummyNavController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NamaDropdown(
    selectedName: String,
    onNameSelected: (String) -> Unit,
    nameOptions: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        TextField(
            value = selectedName,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text("Pilih nama", fontWeight = FontWeight.Bold) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            shape = RoundedCornerShape(0.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color(0xFFFF9800),
                unfocusedIndicatorColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            nameOptions.forEach { name ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = name,
                            fontWeight = FontWeight.Medium,
                            color = if (name == selectedName) Color(0xFF9C27B0) else Color.Black
                        )
                    },
                    onClick = {
                        onNameSelected(name)
                        expanded = false
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}