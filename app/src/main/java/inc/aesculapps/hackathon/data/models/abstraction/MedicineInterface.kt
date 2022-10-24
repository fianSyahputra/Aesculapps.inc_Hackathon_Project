package inc.aesculapps.hackathon.data.models.abstraction

interface MedicineInterface {
    val id: Int
    val name: String
    val ingredient: String
    val category: String
    val description: String
}