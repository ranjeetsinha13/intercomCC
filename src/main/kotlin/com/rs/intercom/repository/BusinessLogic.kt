package com.rs.intercom.repository

import com.rs.intercom.helpers.Constants.CUSTOMER_DISTANCE_KM_DEFAULT
import com.rs.intercom.helpers.Constants.EARTH_RADIUS_KM
import com.rs.intercom.repository.models.Location
import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

private fun Double.convertDegreeToRadian() = this * Math.PI / 180

private fun Location.distanceDifference(location: Location): Double {

    val longitudeDiff = abs(location.longitude - this.longitude).convertDegreeToRadian()
    val latitude1 = location.latitude.convertDegreeToRadian()
    val latitude2 = this.latitude.convertDegreeToRadian()
    val centralAngle = acos(sin(latitude1) * sin(latitude2) + cos(latitude1) * cos(latitude2) * cos(longitudeDiff))
    return EARTH_RADIUS_KM * centralAngle
}

internal fun Location.isWithInRange(location: Location, range: Double = CUSTOMER_DISTANCE_KM_DEFAULT) =
    this.distanceDifference(location) <= range