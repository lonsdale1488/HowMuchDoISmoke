package com.sersh.howmuchdoismoke.ui.Infirmatio

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.jjoe64.graphview.DefaultLabelFormatter
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.sersh.howmuchdoismoke.MainActivity
import com.sersh.howmuchdoismoke.R
import com.sersh.howmuchdoismoke.utils.DateMy
import kotlinx.android.synthetic.main.fragment_information.*
import java.text.SimpleDateFormat
import java.util.*
import org.jetbrains.anko.imageResource as imageResource1


class InformationFragment : androidx.fragment.app.Fragment(), IInfirmationView {

    private val presenter by lazy { InformationPresenter(this) }
    var LOG_TAG = "InformationFragment"
    private var boolean = true
    private lateinit var series: LineGraphSeries<DataPoint>
    private lateinit var graphView: GraphView
    private var dateFormat = SimpleDateFormat("dd.MM")

    private lateinit var animation: AnimationDrawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(com.sersh.howmuchdoismoke.R.layout.fragment_information, container, false)
    }

    override fun setCigaretAverage(number: Int) {
        Log.d(LOG_TAG, "Average - $number")
        smoking_average.text = number.toString()
    }

    override fun setCigaretYestorday(number: Int) {
        Log.d(LOG_TAG, "yestorday - $number")
        smoke_yestorday.text = number.toString()
    }

    override fun setCigaret(number: String) {
        used.text = number
    }

    override fun onResume() {
        super.onResume()
        animation ()
        presenter.setCigaret()
        presenter.smokeYestordsy()
        presenter.smokeAverage()
        presenter.smoukeGraf()
        initLisener()
    }

    private fun animation ()
    {
        val image: RelativeLayout = view!!.findViewById(R.id.relativeLayouTwo)
        image.setBackgroundResource(com.sersh.howmuchdoismoke.R.drawable.anim)
        animation = image.getBackground() as AnimationDrawable
    }

    override fun setType(): Boolean {
        return boolean
    }

    private fun initLisener() {
        image_cigarette.setOnClickListener {
            animation.stop()
            animation.start()
            presenter.addCigaret()
        }

        change_cigarettid.setOnClickListener {
            if (boolean) {
                image_cigarette.setImageResource(com.sersh.howmuchdoismoke.R.mipmap.electrone_cigarett)
                boolean = false
            } else {
                image_cigarette.setImageResource(com.sersh.howmuchdoismoke.R.mipmap.cigarette)
                boolean = true
            }
        }
        statistic_id.setOnClickListener {
            (activity as MainActivity).showStatisticFragment()
        }
        navigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                com.sersh.howmuchdoismoke.R.id.action_one -> {
                    Log.d(LOG_TAG, "navigation ListenerOne")
                }
                com.sersh.howmuchdoismoke.R.id.action_two -> {
                    Log.d(LOG_TAG, "navigation ListenerTwo")
                }
                com.sersh.howmuchdoismoke.R.id.action_three -> {
                    Log.d(LOG_TAG, "navigation ListenerThree")
                }
            }
            false
        }
    }


    override fun overUse() {
        relativeLayout.setBackgroundResource(com.sersh.howmuchdoismoke.R.drawable.back_fon_overuse)
        overuse.setTextColor(resources.getColor(com.sersh.howmuchdoismoke.R.color.colorAccent))
    }

    override fun Chart(list: MutableList<DateMy>) {

        series = LineGraphSeries(getDataPoint(list))
        series.setDrawDataPoints(true)
        series.setDataPointsRadius(10f)
        series.color = resources.getColor(com.sersh.howmuchdoismoke.R.color.graph_color)
        graphView = activity!!.findViewById(com.sersh.howmuchdoismoke.R.id.graph)
        graphView.addSeries(series)
        graphView.gridLabelRenderer.horizontalLabelsColor = resources.getColor(R.color.text_color)
        graphView.gridLabelRenderer.verticalLabelsColor = resources.getColor(R.color.text_color)
        graphView.gridLabelRenderer.horizontalAxisTitleTextSize = resources.getDimension(R.dimen.text_graph)
        graphView.gridLabelRenderer.verticalAxisTitleTextSize = resources.getDimension(R.dimen.text_graph)
        graphView.gridLabelRenderer.gridColor = resources.getColor(com.sersh.howmuchdoismoke.R.color.graph_color)
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