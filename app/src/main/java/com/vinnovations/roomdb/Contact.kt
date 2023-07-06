package com.vinnovations.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactDB")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name: String,
    val mobile: String?
)
