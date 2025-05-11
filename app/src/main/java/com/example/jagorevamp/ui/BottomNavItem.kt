package com.example.jagorevamp.ui

import com.example.jagorevamp.R

sealed class BottomNavItem(
    val route: String,
    val iconActive: Int,
    val iconInactive: Int,
    val label: String
) {
    object Beranda : BottomNavItem(
        "beranda",
        R.drawable.ic_home_active,
        R.drawable.ic_home_inactive,
        "Beranda"
    )
    object Kantong : BottomNavItem(
        "kantong",
        R.drawable.ic_wallet_active,
        R.drawable.ic_wallet_inactive,
        "Kantong"
    )
    object Transaksi : BottomNavItem(
        "transaksi",
        R.drawable.ic_transaksi_active,
        R.drawable.ic_transaksi_inactive,
        "Transaksi"
    )
    object Kartu : BottomNavItem(
        "kartu",
        R.drawable.ic_card_active,
        R.drawable.ic_card_inactive,
        "Kartu"
    )
    object Lainnya : BottomNavItem(
        "lainnya",
        R.drawable.ic_more_active,
        R.drawable.ic_more_inactive,
        "Lainnya"
    )
}
