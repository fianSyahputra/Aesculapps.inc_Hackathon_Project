package inc.aesculapps.hackathon.presentation.home_activity.utils

import android.content.Intent
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShortCutMenu(
    val name: String,
    val imageSrc: Int,
    val movingIntent: Intent?
) : Parcelable