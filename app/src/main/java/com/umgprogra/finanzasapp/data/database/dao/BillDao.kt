package com.umgprogra.finanzasapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.umgprogra.finanzasapp.data.database.entities.BillEntity
import java.time.LocalDate
import java.util.UUID

@Dao
interface BillDao {
    @Query("SELECT * FROM bill_table")
    suspend fun getAll(): List<BillEntity>

    @Query("SELECT * FROM bill_table WHERE uidBills IN (:billIds)")
    suspend fun loadAllByIds(billIds: List<UUID>): List<BillEntity>

    @Query("SELECT * FROM bill_table WHERE bill_date IN (:billDate)")
    suspend fun loadAllByDate(billDate: List<LocalDate>): List<BillEntity>

    @Query("SELECT * FROM BILL_TABLE")
    suspend fun loadBillsDate(): List<BillEntity>

    @Insert
    suspend fun insertAll(vararg bills: BillEntity)

    @Delete
    suspend fun delete(bill: BillEntity)
}