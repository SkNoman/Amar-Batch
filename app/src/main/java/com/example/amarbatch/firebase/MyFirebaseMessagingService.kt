package com.example.amarbatch.firebase

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES.O
import android.util.Log
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.amarbatch.MainActivity
import com.example.amarbatch.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "amar_batch"
const val channelName = "com.example.amarbatch"
@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagingService : FirebaseMessagingService() {

   // @RequiresApi(Build.VERSION_CODES.O)
    @RequiresApi(O)
    @SuppressLint("UnspecifiedImmutableFlag")

    override fun onMessageReceived(message: RemoteMessage) {
        if (message.notification != null){
            generateNotification(message.notification!!.title!!,message.notification!!.body!!)
            Log.e("nlog1","yes")
        }
    }
    @SuppressLint("UnspecifiedImmutableFlag")
    fun generateNotification(title:String, description:String){
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

        var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title,description))
        Log.e("nlog2","yes")


        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= O){
                val notificationChannel = android.app.NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationManager.createNotificationChannel(notificationChannel)
            }

        notificationManager.notify(0,builder.build())

    }

    @SuppressLint("RemoteViewLayout")
    private fun getRemoteView(title: String, description: String): RemoteViews {
        Log.e("nlog3","yes")
        val remoteView = RemoteViews("com.example.amarbatch",R.layout.notification)
        remoteView.setTextViewText(R.id.notification_title,title)
        remoteView.setTextViewText(R.id.notification_description,description)
        remoteView.setImageViewResource(R.id.imageView,R.drawable.oralce_notification_icon)

        return remoteView
    }


}