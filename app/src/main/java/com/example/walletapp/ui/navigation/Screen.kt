package com.example.walletapp.ui.navigation

sealed class Screen(val route: String) {
    object Wallet  : Screen("wallet_screen")
    object History : Screen("transaction_history_screen")
}
