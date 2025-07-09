package com.example.walletapp

import androidx.lifecycle.ViewModel
import java.util.Date
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Locale

class WalletViewModel : ViewModel() {

    private val _balance = MutableStateFlow(120.0)
    val balance: StateFlow<Double> = _balance

    private val _logList = MutableStateFlow<List<String>>(emptyList())
    val logList: StateFlow<List<String>> = _logList

    fun addFunds(amount: Double) {
        _balance.value += amount

        val timestamp = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        val newLog = "[$timestamp] + ₺${"%.2f".format(amount)} eklendi."
        _logList.value = _logList.value + newLog
    }
}

