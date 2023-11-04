package com.umgprogra.finanzasapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.umgprogra.finanzasapp.data.AppDatabase
import com.umgprogra.finanzasapp.data.database.entities.BillEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnBalance = findViewById<AppCompatButton>(R.id.btnBalance)
        btnBalance.setOnClickListener {

            lifecycleScope.launch(Dispatchers.IO) {
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "finance-database"
                ).build()

                val dbBills = db.billDao()


//                val bill:Bill = Bill(UUID.randomUUID(),"Gasto de Agua",(22).toDouble(), LocalDate.parse("2023-06-06") )
//                dbBills.insertAll(bill)
//                val listUUID: List<UUID> = listOf(UUID.fromString("d9ceaa9b-5516-44d5-aeb3-3c7964afb9d1"), UUID.fromString("65508a87-5b07-43d2-878c-6d1ac940344c"))

                val bills:List<BillEntity> = dbBills.loadBillsDate()
                Log.i("DEV", bills.toString())




            }
        }

    }
}