package inc.aesculapps.hackathon.data.repository.dummy_implementation

import android.util.Log
import inc.aesculapps.hackathon.data.models.abstraction.MedInteractionInterface
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedInteraction
import inc.aesculapps.hackathon.data.repository.abstraction.MedInteractionRepositoryInterface
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler
import org.json.JSONObject

class DummyMedInteractionRepository : MedInteractionRepositoryInterface {

    private val dummyDb = listOf<DummyMedInteraction>(
        DummyMedInteraction(
            0,
            0,
            "Dosis Berganda",
            "Anda Mengkonsumsi obat dengan kandungan yang sama. Konsultasikan dengan dokter anda terkati dengan dosis berganda tersebut. Jika anda membeli obat secara mandiri, hentikan salah satunya jika tidak diperlukan hingga anda berkonsultasi lebih lanjut",
            "Parasetamol",
            "Parasetamol (Paratusin)",
            0
        ),
        DummyMedInteraction(
            0,
            0,
            "Interaksi Farmakodinamik",
            "Kombinasi obat yang anda konsumsi memiliki peningkatan risiko toksik hepar. Konsultasikan dengan dokter anda terkait dengan Interaksi Farmakodinamik tersebut. Jika anda membeli obat secara mandiri, hentikan konsums obat yang anda beli hingga anda berkonsultasi lebih lanjut!",
            "Parasetamol",
            "Omeprazole",
            1
        ),
        DummyMedInteraction(
            0,
            0,
            "Interaksi Farmakokinetik",
            "Kombinasi obat yang anda konsumsi memiliki potensi efek Penurunan Absorbsi Parasetamol. Konsultasikan dengan dokter anda terkait dengan Farmakokinetik tersebut!",
            "Parasetamol",
            "Kolestramin (Sequest)",
            2
        )

    )


    override fun getInteractionDataBetweenTwoMedicine(
        firstMedId: Int,
        secondMedId: Int
    ): MedInteractionInterface? {
        val data: MedInteractionInterface? = null
        return data
    }

    override fun getAllUserMedicineInteraction(userMedicineList: List<MedicineInterface>): List<MedInteractionInterface>? {
        val userMedList = LoginHandler.loggedInAccountData!!.medicineList
        val medIdInteractionToFetch = mutableListOf<JSONObject>()

        for (i in userMedList.indices) {
            val med1 = userMedList[i]
            val listToCompare = userMedList.subList(i + 1, userMedList.size - 1)
            for (j in listToCompare.indices) {
                val med2 = listToCompare[j]
                val json = JSONObject()
                json.apply {
                    put("med1id", med1.id)
                    put("med2id", med2.id)
                }
                medIdInteractionToFetch.add(json)
            }
        }
        medIdInteractionToFetch.forEach {
            Log.d("#LOOK AT THIS#", it.toString(1))
        }

        return null
    }

    fun getDummyData(): List<DummyMedInteraction> {
        return dummyDb
    }

}