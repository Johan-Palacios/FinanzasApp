package com.umgprogra.finanzasapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.umgprogra.finanzasapp.data.database.converters.LocalDateConverter
import com.umgprogra.finanzasapp.data.database.dao.BillDao
import com.umgprogra.finanzasapp.data.database.dao.IncomeDao
import com.umgprogra.finanzasapp.data.database.entities.BillEntity
import com.umgprogra.finanzasapp.data.database.entities.IncomeEntity

@Database(entities = [BillEntity::class, IncomeEntity::class], version = 1)
@TypeConverters(LocalDateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun billDao(): BillDao
    abstract fun incomeDao(): IncomeDao
}