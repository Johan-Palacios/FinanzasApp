package com.umgprogra.finanzasapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.UUID

@Entity(tableName = "income_table")
data class IncomeEntity(
    @PrimaryKey val uidIncome: UUID,
    @ColumnInfo(name = "income_description") val incomeDescription: String?,
    @ColumnInfo(name = "income_value") val incomeValue: Double?,
    @ColumnInfo(name = "income_date") val incomeDate: LocalDate?
)
