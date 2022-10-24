package inc.aesculapps.hackathon.utils.apps_notifiation_manager

import android.content.Context
import androidx.core.app.NotificationCompat
import inc.aesculapps.hackathon.R

class AppsNotificationManager {


    companion object {

        const val BASIC_NOTIFICATION_CHANNEL_ID = "ch1-basic-notification"

        fun getBasicNotificationManager(context: Context): NotificationCompat.Builder {
            return NotificationCompat.Builder(context, BASIC_NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.icon_darurat)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setStyle(NotificationCompat.BigTextStyle().bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        }



    }


}