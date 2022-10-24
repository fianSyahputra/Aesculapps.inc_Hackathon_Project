package inc.aesculapps.hackathon.data.models.dummy_implementation

import android.os.Parcelable
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import kotlinx.parcelize.Parcelize

@Parcelize
data class DummyMedicine(
    override val id: Int,
    override val name: String,
    override val ingredient: String,
    override val category: String,
    override val description: String,
    val imageSrc: Int
) : MedicineInterface, Parcelable {
}