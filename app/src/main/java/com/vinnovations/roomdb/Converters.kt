package com.vinnovations.roomdb

import androidx.room.TypeConverter
import java.util.*

class Converters {
// this type of class is very helpful when we want to store our custom types in the database
    @TypeConverter
    fun fromDateToLong(value: Date) : Long{
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long) : Date{
        return Date(value)
    }
}