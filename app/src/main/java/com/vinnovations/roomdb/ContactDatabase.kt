package com.vinnovations.roomdb

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {

    // to link dao class to the database
    abstract fun contactDao() : ContactDao

    // now we are going to use singleton pattern which means there will be only one instance
    // of this class in the whole application

    companion object{

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("AlTER TABLE contactDB ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile // it means if any changes done to instance then all thread will get the updated value
        private var INSTANCE : ContactDatabase? = null

        fun getDatabase(context: Context) : ContactDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB")
                        .addMigrations(migration_1_2)
                        .build()
                }

            }
            return INSTANCE!!
        }
    }
}