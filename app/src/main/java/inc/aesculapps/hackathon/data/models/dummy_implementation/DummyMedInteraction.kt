package inc.aesculapps.hackathon.data.models.dummy_implementation

import android.os.Parcelable
import inc.aesculapps.hackathon.data.models.abstraction.MedInteractionInterface
import kotlinx.parcelize.Parcelize

@Parcelize
data class DummyMedInteraction(
    override val idMed1: Int,
    override val idMed2: Int,
    override val interactionName: String,
    override val description: String,
    override val med1Name: String,
    override val med2Name: String,
    override val warningLevel: Int
) : MedInteractionInterface, Parcelable