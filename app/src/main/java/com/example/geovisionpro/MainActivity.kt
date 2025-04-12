
package com.example.geovisionpro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.footingShapeSpinner)
        val chart = findViewById<LineChart>(R.id.lineChart)

        val shapes = resources.getStringArray(R.array.footing_shapes)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val shape = parent.getItemAtPosition(position).toString()
                val entries = mutableListOf<Entry>()
                val q = 100.0
                val B = 2.0
                val L = 3.0
                val radius = 1.5

                val value = when (shape) {
                    "Square" -> BearingCapacity.calculateSquareFooting(q, B, 1.5)
                    "Rectangular" -> BearingCapacity.calculateRectangularFooting(q, B, L)
                    "Circular" -> BearingCapacity.calculateCircularFooting(q, radius)
                    "Strip" -> BearingCapacity.calculateStripFooting(q, B)
                    else -> 0.0
                }

                entries.add(Entry(0f, 0f))
                entries.add(Entry(1f, value.toFloat()))
                val dataSet = LineDataSet(entries, "$shape Footing Capacity")
                chart.data = LineData(dataSet)
                chart.invalidate()

                Toast.makeText(applicationContext, "Selected: $shape", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
