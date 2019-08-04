package com.sersh.howmuchdoismoke.ui.Infirmatio

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jjoe64.graphview.DefaultLabelFormatter


import kotlinx.android.synthetic.main.fragment_information.*
import com.jjoe64.graphview.series.LineGraphSeries
import com.sersh.howmuchdoismoke.utils.DateMy

import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import java.text.SimpleDateFormat

import java.util.*

import com.sersh.howmuchdoismoke.MainActivity
import com.sersh.howmuchdoismoke.R


class InformationFragment : androidx.fragment.app.Fragment(), IInfirmationView {
  private  val presenter by lazy { InformationPresenter(this) }
    var LOG_TAG = "InformationFragment"
    var boolean = true


    lateinit var series: LineGraphSeries<DataPoint>
    lateinit var graphView: GraphView
    var dateFormat = SimpleDateFormat("dd.MM")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }


    override fun setCigaretAverage(number: Int) {
        Log.d(LOG_TAG, "Average - $number")
        smoking_average.text = number.toString()
    }

    override fun setCigaretYestorday(number: Int) {
        Log.d(LOG_TAG, "yestorday - $number")
        smoke_yestorday.text = number.toString()
    }

    override fun setCigaret(number: Int) {
        used.text = number.toString()
    }


    override fun onResume() {
        super.onResume()
        fisrsSatrt()
        initLisener()
    }

    fun initLisener() {
        image_cigarette.setOnClickListener {
            presenter.addCigaret()
        }
        change_cigarettid.setOnClickListener {
            if (boolean) {
                image_cigarette.setImageResource(com.sersh.howmuchdoismoke.R.drawable.electrone_cigarett)
                boolean = false
            } else {
                image_cigarette.setImageResource(com.sersh.howmuchdoismoke.R.drawable.cigarette)
                boolean = true
            }
        }
        statistic_id.setOnClickListener {
            (activity as MainActivity).showStatisticFragment()
        }
        navigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.action_one -> {
                    Log.d(LOG_TAG, "navigation ListenerOne")

                }
                R.id.action_two -> {
                    Log.d(LOG_TAG, "navigation ListenerTwo")

                }
                R.id.action_three -> {
                    Log.d(LOG_TAG, "navigation ListenerThree")

                }

            }
            false
        }
    }

    fun fisrsSatrt() {
        presenter.setCigaret()
        presenter.smokeYestordsy()
        presenter.somoukeAverage()
        presenter.smoukeGraf()
    }


    override fun Chart(list: MutableList<DateMy>) {
        series = LineGraphSeries(getDataPoint(list))
        graphView = activity!!.findViewById(com.sersh.howmuchdoismoke.R.id.graph)
        graphView.addSeries(series)
        graphView.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String? {
                if (isValueX) {
                    return dateFormat.format(Date(value.toLong()))
                } else {
                    return super.formatLabel(value, isValueX)
                }

            }
        }
    }

    internal fun getDataPoint(list: MutableList<DateMy>): Array<DataPoint> {
        return arrayOf(
            DataPoint(dateFormat.parse(list.get(0).data), list.get(0).number.toDouble()),
            DataPoint(dateFormat.parse(list.get(1).data), list.get(1).number.toDouble()),
            DataPoint(dateFormat.parse(list.get(2).data), list.get(2).number.toDouble()),
            DataPoint(dateFormat.parse(list.get(3).data), list.get(3).number.toDouble()),
            DataPoint(dateFormat.parse(list.get(4).data), list.get(4).number.toDouble()),
            DataPoint(dateFormat.parse(list.get(5).data), list.get(5).number.toDouble()),
            DataPoint(dateFormat.parse(list.get(6).data), list.get(6).number.toDouble()),
            DataPoint(dateFormat.parse(list.get(7).data), list.get(7).number.toDouble())
        )
    }

}