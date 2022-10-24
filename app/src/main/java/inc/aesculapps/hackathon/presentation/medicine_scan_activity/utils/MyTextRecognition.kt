package inc.aesculapps.hackathon.presentation.medicine_scan_activity.utils

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class MyTextRecognition {

    lateinit var showToast: ((String)-> Unit?)


    fun RunTextRecognition(context: Context, imageUri : Uri?) {
        if (imageUri != null){
            Log.d("#_POSITION_POINTER_#","1")
            val image = InputImage.fromFilePath(context, imageUri)
            Log.d("#_POSITION_POINTER_#","2")
            val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
            Log.d("#_POSITION_POINTER_#","3")
            recognizer.process(image)
                .addOnSuccessListener { texts ->
                    Log.d("#_POSITION_POINTER_#","4")
                    //processTextRecognitionResult(texts)
                    processTextRecognitionResultForMeds(texts)
                }
                .addOnFailureListener { e -> // Task failed with an exception
                    Log.d("#_POSITION_POINTER_#","5")
                    e.printStackTrace()
                }
        }
        else return
    }

    private fun processTextRecognitionResult(texts: Text) {
        val blocks = texts.textBlocks
        if (blocks.size == 0) {
            showToast.invoke("No text found")
            return
        }
        var allCapturedText = ""
        for (i in blocks.indices) {
            val lines = blocks[i].lines
            val workingBlock = blocks[i]
            val workingBlockBoundingBox = workingBlock.boundingBox
            val workingBlockCornerPoints = workingBlock.cornerPoints.toString()



            for (j in lines.indices) {
                val elements = lines[j].elements

                val workingLines = lines[j]
                val workingLinesBoundingBox = workingLines.boundingBox
                val workingLinesCornerPoint = workingLines.cornerPoints.toString()



                for (k in elements.indices) {
                    allCapturedText += elements[k].text

                    Log.d("#TEXT:",elements[k].text)
                    Log.d("#BLOCKS","block index $i, " +
                            "blockBoundingBox $workingBlockBoundingBox, " +
                            "block width ${workingBlockBoundingBox?.width()}" +
                            "block height ${workingBlockBoundingBox?.height()}" +

                            " block center ${workingBlockBoundingBox?.centerX()}, ${workingBlockBoundingBox?.centerY()}")

                    Log.d("#LINES", "lines index $j, " +
                            "linesBoundingBox $workingLinesBoundingBox, " +
                            "lines width ${workingLinesBoundingBox?.width()}" +
                            "lines height ${workingLinesBoundingBox?.height()}" +
                            " lines center ${workingLinesBoundingBox?.centerX()}, ${workingLinesBoundingBox?.centerY()}")


                }
                allCapturedText += " "
            }
            allCapturedText += "\n"
        }

        Log.d("ALL_CAPTURED_TEXT#", allCapturedText)

    }

    private fun processTextRecognitionResultForMeds(texts: Text){
        val blocks = texts.textBlocks
        if (blocks.size == 0) {
            showToast.invoke("No text found")
            return
        }

        var highestLineHeight: Int = 0
        var highestLineIndex: Int = 0
        val medTitles = mutableListOf<String>()

        for (i in blocks.indices) {
            val lines = blocks[i].lines

            for (j in lines.indices) {

                val workingLine = lines[j]
                if (workingLine.boundingBox!!.height() > highestLineHeight) {
                    highestLineHeight = workingLine.boundingBox!!.height()
                    highestLineIndex = j
                    medTitles.clear()

                    val elements = lines[j].elements

                    for (k in elements.indices) {
                        //allCapturedText += elements[k].text
                        medTitles.add(elements[k].text)
                    }
                }
            }
        }
        Log.d("#medTitles : ",medTitles.toString())
    }

}