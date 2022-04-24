package com.example.datawarehouseproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        val result = intent.getStringExtra("result")
        val donut_view = findViewById<DonutProgressView>(R.id.donut_view)


        val resultFloat = result?.toFloat()
        resultTextView.text = result.toString()

        val section1 = DonutSection(
            name = "section_1",
            color = Color.parseColor("#FB1D32"),
            amount = resultFloat!!
        )

        donut_view.cap = 20f
        donut_view.submitData(listOf(section1))

    }
}