package com.vinnovations.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao{

// suspend will work with coroutines
 @Insert
 suspend fun insertContact(contact: Contact)

 @Delete
 suspend fun deleteContact(contact: Contact)

 @Update
 suspend fun updateContact(contact: Contact)

 @Query("SELECT * FROM contactDB")
 fun getContact(): LiveData<List<Contact>> // LiveData will proceed this task on background thread
}