package com.vinnovations.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    // to link dao class to the database
    abstract fun contactDao() : ContactDao
}