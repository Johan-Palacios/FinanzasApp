package com.umgprogra.finanzasapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.lifecycleScope
import com.umgprogra.finanzasapp.R
import com.umgprogra.finanzasapp.data.AppDatabase
import com.umgprogra.finanzasapp.data.database.dao.BillDao
import com.umgprogra.finanzasapp.data.database.dao.IncomeDao
import com.umgprogra.finanzasapp.data.database.entities.BillEntity
import com.umgprogra.finanzasapp.data.database.entities.IncomeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowBalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_balance)

        val tvIncomeSummary = findViewById<AppCompatTextView>(R.id.tvIncomeSummary)
        val tvBillSummary = findViewById<AppCompatTextView>(R.id.tvBillSummary)
        val tvBalanceSummary = findViewById<AppCompatTextView>(R.id.tvBalanceSummary)

        var sumIncomes: Double = 0.0
        var sumBills: Double = 0.0

        lifecycleScope.launch(Dispatchers.IO) {
            val db: AppDatabase = AppDatabase.getInstance(applicationContext)

            val dbIncome: IncomeDao = db.incomeDao()
            val dbBills: BillDao = db.billDao()

            val billList: List<BillEntity> = dbBills.getAll()
            val incomeList: List<IncomeEntity> = dbIncome.getAll()

            Log.i("DEV", billList.toString())

            sumBills = billList.sumOf { it.billValue ?: 0.0 }
            sumIncomes = incomeList.sumOf { it.incomeValue ?: 0.0 }

            tvIncomeSummary.text = sumIncomes.toString()
            tvBillSummary.text = sumBills.toString()
            tvBalanceSummary.text = (sumIncomes - sumBills).toString()
        }


    }
}