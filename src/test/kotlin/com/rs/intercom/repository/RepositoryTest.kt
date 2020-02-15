package com.rs.intercom.repository

import com.rs.intercom.helpers.Constants.CUSTOMERS_FILE_PATH
import com.rs.intercom.repository.models.Customer
import org.junit.Assert
import org.junit.Test

class RepositoryTest {

    @Test
    fun testConvertToJSONStr() {
        val customerList = arrayListOf(
            Customer(5, "rs", "12.34", "13.56"),
            Customer(8, "rs3", "12.34", "13.56"),
            Customer(2, "rs1", "12.34", "13.56")
        )
        val str = Repository.convertToJSONStr(customerList)
        Assert.assertTrue(str.isNotEmpty())
        Assert.assertEquals(
            "[{\"name\":\"rs\",\"latitude\":\"12.34\",\"longitude\":\"13.56\"," +
                    "\"userId\":5},{\"name\":\"rs3\",\"latitude\":\"12.34\",\"longitude\":\"13.56\"," +
                    "\"userId\":8},{\"name\":\"rs1\",\"latitude\":\"12.34\",\"longitude\":\"13.56\",\"userId\":2}]", str
        )
    }

    @Test
    fun testListOfCustomers() {
        val customers = Repository.listOfCustomers(CUSTOMERS_FILE_PATH)
        Assert.assertTrue(customers?.isNotEmpty() == true)
        Assert.assertTrue(customers is List)
        Assert.assertEquals(customers?.size, 32)
    }

    @Test
    fun testListOfCustomersEmpty() {
        val customerList = Repository.listOfCustomers("random.txt")
        Assert.assertTrue(customerList?.isEmpty() == true)
    }
}