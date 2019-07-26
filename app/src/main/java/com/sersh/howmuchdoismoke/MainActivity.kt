package com.sersh.howmuchdoismoke

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NotificationCompat
import com.sersh.howmuchdoismoke.ui.InformationFragment
import com.sersh.howmuchdoismoke.ui.StatisticFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notification()
        showInformationFragment()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).addToBackStack(null).commit()
    }

    fun showInformationFragment() {
        replaceFragment(InformationFragment())
    }
    fun showStatisticFragment() {
        replaceFragment(StatisticFragment())
    }

    fun addNotification(notification: Notification, id:Int)
    {
        var nonificationMeneger =   getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        nonificationMeneger.notify(id,notification)
    }


    fun notification()
    {
        val intentMA = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivities(this,0, arrayOf(intentMA), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.smallicon)
            .setContentTitle("Кількість курева")
            .setContentText("Торкніться, щоб натиснути на кнопку")
            .setContentInfo("Кількість курева")
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .setColor(resources.getColor(R.color.cucle_color))
        var notification = builder.build()
        addNotification(notification,1)
    }
}
