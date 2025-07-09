package com.example.walletapp.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.walletapp.WalletViewModel
import com.example.walletapp.ui.navigation.Screen

@Composable
fun WalletScreen(
    navController: NavHostController,
    viewModel: WalletViewModel          //  ← ViewModel parametreyle geliyor
) {
    val balance by viewModel.balance.collectAsState()
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.History.route)
            }) {
                Icon(
                    imageVector = Icons.Filled.History,
                    contentDescription = "Geçmiş"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Cüzdan Bakiyesi: ₺${"%.2f".format(balance)}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                viewModel.addFunds(100.0)
                Toast.makeText(context, "Paranız eklendi", Toast.LENGTH_SHORT).show()
            }) {
                Text("+100 TL Ekle")
            }
        }
    }
}
