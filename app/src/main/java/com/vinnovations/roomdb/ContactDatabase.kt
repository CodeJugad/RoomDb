package com.vinnovations.roomdb

import android.content.Context
import androidx.room.*

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {

    // to link dao class to the database
    abstract fun contactDao() : ContactDao

    // now we are going to use singleton pattern which means there will be only one instance
    // of this class in the whole application
    companion object{
        @Volatile // it means if any changes done to instance then all thread will get the updated value
        private var INSTANCE : ContactDatabase? = null

        fun getDatabase(context: Context) : ContactDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB").build()
                }

            }
            return INSTANCE!!
        }
    }
}