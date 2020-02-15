package com.rs.intercom.repository.datamodel

import com.rs.intercom.repository.models.Customer
import org.junit.Assert
import org.junit.Test

class CustomerTest {

    @Test
    fun testCustomerData() {
        val customer = Customer(2, "ns", "45.0", "33.0")
        Assert.assertTrue(customer.name == "ns")
        Assert.assertTrue(customer.latitude == "45.0")
        Assert.assertTrue(customer.latitude.toDouble() == 45.0)
    }
}