package com.rs.intercom

import com.rs.intercom.helpers.Constants
import com.rs.intercom.helpers.getFileData
import com.rs.intercom.helpers.sortByID
import com.rs.intercom.helpers.writeToFile
import com.rs.intercom.repository.models.Customer
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.io.IOException

class HelpersTest {

    @Test
    fun testWriteToFile() {
        "Something".writeToFile("test.txt")
        Assert.assertTrue(File("test.txt").exists())
    }

    @Test(expected = IOException::class)
    fun testGetFileDataException() {
        "notExist".getFileData()
    }

    @Test
    fun testGetFileData() {
        val data = Constants.CUSTOMERS_FILE_PATH.getFileData()
        Assert.assertTrue(data != null)
        Assert.assertTrue(data?.isNotEmpty() == true)
        Assert.assertTrue(data?.size == 32)
        data?.forEach {
            Assert.assertTrue(it is String)
        }
    }

    @Test
    fun testSortByID() {
        val list = mutableListOf(
            Customer(5, "rs", "12.34", "13.56"),
            Customer(8, "rs3", "12.34", "13.56"),
            Customer(2, "rs1", "12.34", "13.56")
        )

        val sorted = list.sortByID()
        Assert.assertTrue(sorted.isNotEmpty())
        Assert.assertTrue(sorted.size == 3)
        Assert.assertTrue(sorted[0].name == "rs1" && sorted[1].name == "rs")
    }
}