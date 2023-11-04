package com.umgprogra.finanzasapp.data.database.converters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDateConverter {
    @TypeConverter
    fun localDateToString(date: LocalDate?): String {
        return date.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun stringToLocalDate(date: String?): LocalDate {
        return LocalDate.parse(date)
    }
}