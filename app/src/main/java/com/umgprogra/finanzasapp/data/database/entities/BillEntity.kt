package com.umgprogra.finanzasapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.UUID

@Entity(tableName = "bill_table")
data class BillEntity(
    @PrimaryKey val uidBills: UUID,
    @ColumnInfo(name = "bill_description") val billDescription: String?,
    @ColumnInfo(name = "bill_value") val billValue: Double?,
    @ColumnInfo(name = "bill_date") val billDate: LocalDate?
)

