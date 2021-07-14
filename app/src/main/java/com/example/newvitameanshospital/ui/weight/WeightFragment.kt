package com.example.newvitameanshospital.ui.weight

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newvitameanshospital.databinding.FragmentWeightBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class WeightFragment : Fragment() {
    lateinit var binding: FragmentWeightBinding
    lateinit var chartview: BarChart


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("WeightFragment","attach")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setChart()
        setData()
    }

    private fun setChart() {
        binding.apply {

            chart.setDrawBarShadow(false)
            chart.setDrawValueAboveBar(true)
            chart.description.isEnabled = false
            chart.setPinchZoom(false)
            chart.setDrawGridBackground(false)
            chart.isDoubleTapToZoomEnabled = false

            var legend = chart.legend
            legend.isEnabled = false

            var xAxis = chart.xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.setDrawGridLines(false)
            xAxis.labelCount = 7
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    return value.toInt().toString()
                }
            }

            var yLAxis = chart.axisLeft
            yLAxis.setDrawLabels(false)
            yLAxis.setDrawAxisLine(false)
            yLAxis.setDrawGridLines(false)
            yLAxis.axisMaximum = 80f
            yLAxis.axisMinimum = 0f
            yLAxis.labelCount = 3

            var yRAxis = chart.axisRight
            yRAxis.setDrawLabels(false)
            yRAxis.setDrawAxisLine(false)
            yRAxis.setDrawGridLines(false)
        }.also { chartview = it.chart }
    }

    fun setData() {

        val values = ArrayList<BarEntry>()

        values.add(BarEntry(1f, 77.2f))
        values.add(BarEntry(2f, 75.4f))
        values.add(BarEntry(3f, 72.8f))
        values.add(BarEntry(4f, 70.1f))
        values.add(BarEntry(5f, 68.6f))
        values.add(BarEntry(6f, 65.2f))
        values.add(BarEntry(7f, 63.3f))

        val set1: BarDataSet
        if (chartview.data != null &&
            chartview.data.dataSetCount > 0
        ) {
            set1 = chartview.data.getDataSetByIndex(0) as BarDataSet
            set1.values = values
            chartview.data.notifyDataChanged()
            chartview.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(values, "Weight")
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
