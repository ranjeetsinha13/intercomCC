package com.rs.intercom.repository.datamodel

import com.rs.intercom.repository.models.Location
import org.junit.Assert
import org.junit.Test

class LocationTest {

    @Test
    fun testLocation() {
        val location = Location(33.0, 24.0)
        Assert.assertTrue(location.latitude == 33.0)
        Assert.assertTrue(location.longitude == 24.0)
    }
}