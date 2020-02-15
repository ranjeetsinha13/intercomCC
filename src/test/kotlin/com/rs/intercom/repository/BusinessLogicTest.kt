package com.rs.intercom.repository

import com.rs.intercom.repository.models.Location
import org.junit.Assert
import org.junit.Test

class BusinessLogicTest {

    @Test
    fun testDistanceDifference() {
        val inRange = Location(23.0, 14.0).isWithInRange(Location(11.0, 14.0))
        Assert.assertFalse(inRange)

        val inRangeTrue = Location(23.0, 14.0).isWithInRange(Location(23.0, 14.0), 40.0)

        Assert.assertTrue(inRangeTrue)
    }
}