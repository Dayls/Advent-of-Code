package day1_SonarSweep.kotlinSolution

import java.io.File
import java.io.InputStream

class Loader(path: String) {

     val data = loadData(path)

    private fun loadData(path:String): List<Int> {
        try {
            val inputStream: InputStream = File(path).inputStream()

            val intList = mutableListOf<Int>()
            inputStream.bufferedReader().forEachLine {
                if (it.isNotEmpty()) {
                    intList.add(it.toInt())
                }
            }

            return intList
        } catch (e: java.io.FileNotFoundException) {
            println("File not found!")
        }

        return emptyList()
    }

}