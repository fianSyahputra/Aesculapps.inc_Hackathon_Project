package inc.aesculapps.hackathon.data.repository.dummy_implementation

import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.data.repository.abstraction.MedicineRepositoryInterface
import java.util.Calendar

class DummyMedicineRepository : MedicineRepositoryInterface {

    private val dummyMedicineDb = listOf<DummyMedicine>(
        DummyMedicine(
            1,
            "ERYSANBE",
            "",
            "Antibiotik & Anti Jamur",
            "",
            R.drawable.dummy_erysanbe
        ),
        DummyMedicine(
            2,
            "PANADOL EXTRA",
            "",
            "Anti Nyeri, Kebutuhan Lebaran",
            "",
            R.drawable.dummy_panadol_extra
        ),
        DummyMedicine(
            3,
            "VOMIGO 4MG",
            "",
            "",
            "",
            R.drawable.dummy_vomigo4mg
        ),
        DummyMedicine(
            4,
            "FG TROCHES",
            "",
            "Antibiotik & Anti Jamur",
            "",
            R.drawable.dummy_fg_troches
        )
    )

    override fun getSingleMedicineData(id: Int): MedicineInterface? {
        var data : MedicineInterface? = null
        dummyMedicineDb.forEach {
            if (it.id == id){
                data = it
            }
        }

        return data
    }

    override fun getUserMedicineList(userId: Int): List<MedicineInterface> {
        return dummyMedicineDb
    }
}