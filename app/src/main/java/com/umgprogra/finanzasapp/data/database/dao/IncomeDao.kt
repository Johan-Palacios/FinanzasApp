package com.umgprogra.finanzasapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.umgprogra.finanzasapp.data.database.entities.IncomeEntity

@Dao
interface IncomeDao {
    @Query("SELECT * FROM income_table")
    suspend fun getAll(): List<IncomeEntity>

    @Query("SELECT * FROM income_table WHERE uidIncome IN (:incomeIds)")
    suspend fun loadAllByIds(incomeIds: IntArray): List<IncomeEntity>

    @Query("SELECT * FROM income_table WHERE income_date IN (:incomeDate)")
    suspend fun loadAllByDate(incomeDate: IntArray): List<IncomeEntity>

    @Insert
    suspend fun insertAll(vararg incomes: IncomeEntity)

    @Delete
    suspend fun delete(income: IncomeEntity)
}