package com.umgprogra.finanzasapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
    companion object {
        private const val Database_NAME = "finance-database"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        Database_NAME
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}