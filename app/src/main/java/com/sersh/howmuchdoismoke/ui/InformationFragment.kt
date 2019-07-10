package com.sersh.howmuchdoismoke.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import kotlinx.android.synthetic.main.fragment_information.*

//import com.jjoe64.graphview.series.LineGraphSeries
//import com.jjoe64.graphview.series.DataPoint
import com.sersh.howmuchdoismoke.R


class InformationFragment: Fragment(), IInfirmationView {
    val presenter by lazy { InformationPresenter(this) }
    var LOG_TAG = "InformationFragment"

    var  boolean = true

 //   private val mMonth = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
//    private val mChart: GraphicalView? = null
//    private val mDataset = XYMultipleSeriesDataset()
//    private val mRenderer = XYMultipleSeriesRenderer()
//    private var mCurrentSeries: XYSeries? = null
//    private var mCurrentRenderer: XYSeriesRenderer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_information, container, false)
    }



    override fun setCigaretAverage(number: Int) {
        Log.d(LOG_TAG,"Average - $number" )
        smoking_average.text = number.toString()
    }

    override fun setCigaretYestorday(number: Int) {
        Log.d(LOG_TAG,"yestorday - $number" )
        smoke_yestorday.text = number.toString()
    }

    override fun setCigaret(number: Int) {
        used.text = number.toString()
    }


    override fun onResume() {
        super.onResume()
     //   fisrsSatrt ()
        initLisener()
      //  Chart ()


    }

    fun initLisener()
    {
        image_cigarette.setOnClickListener {
            presenter.addCigaret()
        }
        change_cigarettid.setOnClickListener {
            if(boolean )
            {
                image_cigarette.setImageResource(R.drawable.electrone_cigarett)
                boolean = false
            } else {
                image_cigarette.setImageResource(R.drawable.cigarette)
                boolean = true
            }
        }

    }

//    fun fisrsSatrt ()
//    {   presenter.setCigaret()
//        presenter.smokeYestordsy()
//        presenter.somoukeAverage()
//    }



//    fun Chart ()
//    {
//
//        var series = LineGraphSeries<DataPoint>(arrayOf<DataPoint>(
//                DataPoint(0.0, 1.0),
//                DataPoint(1.0, 5.0),
//                DataPoint(2.0, 3.0),
//                DataPoint(3.0, 2.0),
//                DataPoint(4.0, 6.0)))
//        graph.addSeries(series)
//    }


}