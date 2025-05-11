package com.example.jagorevamp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jagorevamp.R

val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold)
)


val TitleB = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 30.sp
)

val TitleM = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 30.sp
)

val HeadingLB = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 36.sp,
)

val HeadingLM = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
    lineHeight = 36.sp
)

val HeadingMB = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp,
    lineHeight = 30.sp
)
val HeadingMM = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 30.sp
)

val HeadingMBS = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

//Body
val BodyLB = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    lineHeight = 27.sp
)

val BodyLM = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    lineHeight = 27.sp)

val BodyMB = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 24.sp)

val BodyMM = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp
)
val BodySB = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 21.sp)

val BodySM = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 21.sp)

val CaptionB = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 18.sp)

val CaptionM = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 18.sp)

