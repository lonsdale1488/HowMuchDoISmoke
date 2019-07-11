package com.sersh.howmuchdoismoke.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import kotlinx.android.synthetic.main.fragment_information.*

import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.sersh.howmuchdoismoke.DateMy
import com.sersh.howmuchdoismoke.R


class InformationFragment : Fragment(), IInfirmationView {
    val presenter by lazy { InformationPresenter(this) }
    var LOG_TAG = "InformationFragment"

    var boolean = true


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
        //  Chart ()


    }

    fun initLisener() {
        image_cigarette.setOnClickListener {
            presenter.addCigaret()
        }
        change_cigarettid.setOnClickListener {
            if (boolean) {
                image_cigarette.setImageResource(R.drawable.electrone_cigarett)
                boolean = false
            } else {
                image_cigarette.setImageResource(R.drawable.cigarette)
                boolean = true
            }
        }

    }

    fun fisrsSatrt() {
        presenter.setCigaret()
        presenter.smokeYestordsy()
        presenter.somoukeAverage()
        presenter.smoukeGraf()
    }


    override fun Chart(list: MutableList<DateMy>) {


        var series = LineGraphSeries<DataPoint>(
            arrayOf<DataPoint>(
                DataPoint(list.get(0).data.toDouble(), list.get(0).number.toDouble()),
                DataPoint(list.get(1).data.toDouble(), list.get(1).number.toDouble()),
                DataPoint(list.get(2).data.toDouble(), list.get(2).number.toDouble()),
                DataPoint(list.get(3).data.toDouble(), list.get(3).number.toDouble()),
                DataPoint(list.get(4).data.toDouble(), list.get(4).number.toDouble()),
                DataPoint(list.get(5).data.toDouble(), list.get(5).number.toDouble()),
                DataPoint(list.get(6).data.toDouble(), list.get(6).number.toDouble()),
                DataPoint(list.get(7).data.toDouble(), list.get(7).number.toDouble())
            )
        )
        
        graph.addSeries(series)

    }


}