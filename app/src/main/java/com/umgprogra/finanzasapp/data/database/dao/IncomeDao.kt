package com.umgprogra.finanzasapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.umgprogra.finanzasapp.data.database.entities.BillEntity
import com.umgprogra.finanzasapp.data.database.entities.IncomeEntity
import java.util.UUID

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

    @Update
    suspend fun update(income: IncomeEntity)

    @Query("DELETE FROM income_table WHERE uidIncome IN (:incomeId)")
    suspend fun deleteById(incomeId: UUID)

    @Delete
    suspend fun delete(income: IncomeEntity)
}