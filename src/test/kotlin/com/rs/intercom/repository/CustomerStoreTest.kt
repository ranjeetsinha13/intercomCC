package com.rs.intercom.repository

import com.rs.intercom.helpers.Constants
import com.rs.intercom.repository.models.Location
import org.junit.Assert
import org.junit.Test

class CustomerStoreTest {

    @Test
    fun testListNearByCustomers() {
        val nearByCustomers = CustomerStore.listNearByCustomers(
            Constants.CUSTOMERS_FILE_PATH,
            Constants.DUBLIN_OFFICE_LOCATION,
            Constants.CUSTOMER_DISTANCE_KM_DEFAULT
        )
        Assert.assertTrue(nearByCustomers.isNotEmpty())
        Assert.assertEquals(nearByCustomers.size, 16)
    }

    @Test
    fun testListNearByCustomersEmptyList() {
        val nearByCustomers = CustomerStore.listNearByCustomers(
            "random.txt",
            Location(2.0, 2.0),

            500.0
        )
        Assert.assertTrue(nearByCustomers.isEmpty())
    }
}