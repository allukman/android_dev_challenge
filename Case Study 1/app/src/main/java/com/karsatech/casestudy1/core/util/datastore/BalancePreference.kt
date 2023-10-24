package com.karsatech.casestudy1.core.util.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "balance")


class BalancePreferences private constructor(private val dataStore: DataStore<Preferences>) {

    private val BALANCE_KEY = intPreferencesKey("BALANCE_KEY")

    fun getBalance(): Flow<Int> {
        return dataStore.data.map { preferences ->
            preferences[BALANCE_KEY] ?: 100000000
        }
    }

    suspend fun saveBalance(newBalance: Int) {
        dataStore.edit { preferences ->
            preferences[BALANCE_KEY] = newBalance
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: BalancePreferences? = null

        fun getInstance(datastore: DataStore<Preferences>): BalancePreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = BalancePreferences(datastore)
                INSTANCE = instance
                instance
            }
        }
    }
}