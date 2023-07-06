package com.vinnovations.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this is not a good practice generally people use singleton for this
        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            // this can only call with coroutine or with a suspend function
            database.contactDao().insertContact(Contact(0, "yogi", "88898", Date()))
        }

    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.d("CodeJugad", it.toString())
        })
    }
}