package com.karsatech.casestudy1.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.karsatech.casestudy1.core.util.datastore.BalancePreferences
import kotlinx.coroutines.launch

class BalanceViewModel(private val pref: BalancePreferences) : ViewModel() {

    fun getCurrentBalance(): LiveData<Int> {
        return pref.getBalance().asLiveData()
    }

    fun setCurrentBalance(balance: Int) {
        viewModelScope.launch {
            pref.saveBalance(balance)
        }
    }

}