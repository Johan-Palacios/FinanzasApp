package com.umgprogra.finanzasapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.umgprogra.finanzasapp.ui.BillActivity
import com.umgprogra.finanzasapp.ui.IncomeActivity
import com.umgprogra.finanzasapp.ui.ShowBalanceActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvBalance = findViewById<CardView>(R.id.cvBalance)
        val cvIncome = findViewById<CardView>(R.id.cvInsertIncome)
        val cvBill = findViewById<CardView>(R.id.cvInsertBills)

        cvBalance.setOnClickListener {
            goToShowBalance()
        }
        cvIncome.setOnClickListener {
            goToIncome()
        }
        cvBill.setOnClickListener {
            goToBills()
        }
    }

    private fun goToShowBalance() {
        val intent: Intent = Intent(this, ShowBalanceActivity::class.java)
        startActivity(intent)
    }

    private fun goToIncome() {
        val intent: Intent = Intent(this, IncomeActivity::class.java)
        startActivity(intent)
    }

    private fun goToBills() {
        val intent: Intent = Intent(this, BillActivity::class.java)
        startActivity(intent)
    }
}