package com.example.notification2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService

class MyBroadcast : BroadcastReceiver() {
    private val CHANNEL_ID = "channel_ID"
    private val notificationID = 101

    override fun onReceive(context: Context?, intent: Intent?) {
       if (intent?.action == "com.example.myapp.MY_CUSTOM_INTENT"){
        createNotificationChannel(context)
        sendNotification(context) }}


    private fun createNotificationChannel(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "jd"
            val descriptionText = "cn"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationSystemService = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationSystemService.createNotificationChannel(channel)

        }

    }

    private fun sendNotification(context: Context?) {


        val notification = NotificationCompat.Builder(context!!, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("informacje z aplikacji 1")
            .setContentTitle("Produkt został dodany do listy")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(PendingIntent.getActivity(context,1,
                Intent(context,SecondaryActivity::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT))
        with(NotificationManagerCompat.from(context)) {
            notify(notificationID, notification.build())
        }

}
}