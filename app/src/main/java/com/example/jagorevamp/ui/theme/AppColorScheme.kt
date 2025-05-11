package com.example.jagorevamp.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColorScheme(
    val netral_primaryBG: Color,
    val netral_disabledButton: Color,
    val netral_iconColor: Color,
    val netral_helperFont: Color,
    val netral_typeCardBFFont: Color,
    val netral_descHeadingFont: Color,
    val netral_generalFont: Color,
    val primer_base: Color,
    val primer_default: Color,
    val info_base: Color,
    val info_default: Color,
    val yellow_base: Color,


    )

val LightAppColors = AppColorScheme(
    netral_primaryBG = Color(0xFFFFFFFF),
    netral_disabledButton = Color(0xFFCCCCCC),
    netral_iconColor = Color(0xFF7F7F7F),
    netral_helperFont = Color(0xFF666666),
    netral_typeCardBFFont = Color(0xFF333333),
    netral_descHeadingFont = Color(0xFF191919),
    netral_generalFont = Color(0xFF040404),
    primer_base = Color(0xFFFFF5FF),
    primer_default = Color(0xFF86047E),
    info_base = Color(0xFFFFF4D4),
    info_default = Color(0xFF663900),
    yellow_base = Color(0xFFCC7A00)
    )

val DarkAppColors = AppColorScheme(
    netral_primaryBG = Color(0xFFFFFFFF),
    netral_disabledButton = Color(0xFFCCCCCC),
    netral_iconColor = Color(0xFF7F7F7F),
    netral_helperFont = Color(0xFF666666),
    netral_typeCardBFFont = Color(0xFF333333),
    netral_descHeadingFont = Color(0xFF191919),
    netral_generalFont = Color(0xFF040404),
    primer_base = Color(0xFFFFF5FF),
    primer_default = Color(0xFF86047E),
    info_base = Color(0xFFFFF4D4),
    info_default = Color(0xFF663900),
    yellow_base = Color(0xFFCC7A00)
)

val LocalAppColors = staticCompositionLocalOf { LightAppColors }
