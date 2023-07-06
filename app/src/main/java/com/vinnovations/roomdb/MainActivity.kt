package com.vinnovations.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this is not a good practice generally people use singleton for this
        database = Room.databaseBuilder(applicationContext,
                   ContactDatabase::class.java,
                   "contactDB").build()

        GlobalScope.launch {
            // this can only call with coroutine or with a suspend function
            database.contactDao().insertContact(Contact(0, "yogi", "88898"))
        }

    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.d("CodeJugad", it.toString())
        })
    }
}