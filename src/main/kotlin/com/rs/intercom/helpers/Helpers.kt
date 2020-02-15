package com.rs.intercom.helpers

import com.rs.intercom.repository.models.Customer
import java.io.*


private const val TAG = "Helpers"

// Here String is file path
@Throws(IOException::class)
internal fun String?.getFileData(): List<String?>? {
    this?.let {
        val inputStream: InputStream = ClassLoader.getSystemResourceAsStream(this)
            ?: throw IOException("resource not found: $this")
        return getStringFromInputStream(inputStream)
    }
    return null
}

internal fun List<Customer>.sortByID() = this.sortedBy { it.userId }

internal fun String.writeToFile(fileName: String) {
    val fileObject = File(fileName)
    fileObject.writeText(this)
}

private fun getStringFromInputStream(inputStream: InputStream): List<String> {

    val listOfCustStr = mutableListOf<String>()
    val br = BufferedReader(InputStreamReader(inputStream))
    var line = br.readLine()
    while (line != null) {
        listOfCustStr.add(line)
        line = br.readLine()
    }
    try {
        br.close()
    } catch (ex: IOException) {
        Logger.logE(TAG, "${ex.localizedMessage}")
    }
    return listOfCustStr
}
