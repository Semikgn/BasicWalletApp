package com.example.walletapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.walletapp.WalletViewModel
import com.example.walletapp.ui.navigation.Screen
import com.example.walletapp.ui.screen.TransactionHistoryScreen
import com.example.walletapp.ui.screen.WalletScreen
import com.example.walletapp.ui.theme.WalletAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WalletApp() }
    }
}

@Composable
fun WalletApp() {
    WalletAppTheme {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}
@Composable
fun NavGraph(navController: NavHostController) {
    val sharedViewModel: WalletViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Wallet.route
    ) {
        composable(Screen.Wallet.route) {
            WalletScreen(
                navController = navController,
                viewModel = sharedViewModel
            )
        }
        composable(Screen.History.route) {
            TransactionHistoryScreen(
                navController = navController,
                viewModel = sharedViewModel
            )
        }
    }
}