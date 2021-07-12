package com.example.newvitameanshospital.ui.weight

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.newvitameanshospital.databinding.FragmentWeightBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import java.util.*


class WeightFragment : Fragment() {

    lateinit var binding: FragmentWeightBinding
    lateinit var chartview: BarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setChart()
        setData(7, 20f)
    }

    private fun setChart() {
        binding.apply {

            chart.setDrawBarShadow(false)
            chart.setDrawValueAboveBar(true)
            chart.description.isEnabled = false
            chart.setPinchZoom(false)
            chart.setDrawGridBackground(false)


            var legend = chart.legend
            legend.isEnabled = false

            var xAxis = chart.xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.setDrawGridLines(false)
            xAxis.labelCount = 7
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float, axis: AxisBase?): String {
                    return value.toString()
                }
            }

            var yLAxis = chart.axisLeft
            yLAxis.setDrawLabels(false)
            yLAxis.setDrawAxisLine(false)
            yLAxis.setDrawGridLines(false)

            var yRAxis = chart.axisRight
            yRAxis.setDrawLabels(false)
            yRAxis.setDrawAxisLine(false)
            yRAxis.setDrawGridLines(false)

        }.also { chartview = it.chart }
    }

    fun setData(count: Int, range: Float) {
        val start = 1f
        val values = ArrayList<BarEntry>()
        var i = start.toInt()
        while (i < start + count) {
            val `val` = (Math.random() * (range + 1)).toFloat()
            values.add(BarEntry(i.toFloat(), `val`))

            i++
        }
        val set1: BarDataSet
        if (chartview.data != null &&
            chartview.data.dataSetCount > 0
        ) {
            set1 = chartview.data.getDataSetByIndex(0) as BarDataSet
            set1.values = values
            chartview.data.notifyDataChanged()
            chartview.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(values, "The year 2017")
            set1.setDrawIcons(false)
            val dataSets = ArrayList<IBarDataSet>()
            dataSets.add(set1)
            val data = BarData(dataSets)
            data.setValueTextSize(10f)
            data.setDrawValues(false)
            data.barWidth = 0.6f
            chartview.data = data
        }

    }
}