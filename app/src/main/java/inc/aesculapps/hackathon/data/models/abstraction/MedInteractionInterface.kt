package inc.aesculapps.hackathon.data.models.abstraction

interface MedInteractionInterface {

    val idMed1: Int
    val idMed2: Int
    val med1Name: String
    val med2Name: String
    val warningLevel: Int
    val interactionName: String
    val description: String

}