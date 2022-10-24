package inc.aesculapps.hackathon.utils.riwayat_pindaian_handler

import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine

class RiwayatPindaianHandler {

    companion object {
        var cache = mutableListOf<MedicineInterface>()
        private var dummyCache = mutableListOf<MedicineInterface>()

        fun getDummyCache(): MutableList<MedicineInterface> {
            if(dummyCache.isEmpty()){
                dummyCache.apply {
                    add(
                        DummyMedicine(
                            1,
                            "ERYSANBE",
                            "",
                            "Antibiotik & Anti Jamur",
                            "",
                            R.drawable.dummy_erysanbe
                        )
                    )
                    add(
                        DummyMedicine(
                            2,
                            "PANADOL EXTRA",
                            "",
                            "Anti Nyeri, Kebutuhan Lebaran",
                            "",
                            R.drawable.dummy_panadol_extra
                        )
                    )
                    add(
                        DummyMedicine(
                            3,
                            "VOMIGO 4MG",
                            "",
                            "",
                            "",
                            R.drawable.dummy_vomigo4mg
                        )
                    )
                    add(
                        DummyMedicine(
                            4,
                            "FG TROCHES",
                            "",
                            "Antibiotik & Anti Jamur",
                            "",
                            R.drawable.dummy_fg_troches
                        )
                    )
                }
            }
            return dummyCache
        }


    }



}