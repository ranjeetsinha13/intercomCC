package com.rs.intercom.helpers

import com.rs.intercom.repository.models.Location

internal object Constants {

    const val CUSTOMER_DISTANCE_KM_DEFAULT = 100.0
    const val EARTH_RADIUS_KM = 6371
    private const val DUBLIN_OFFICE_LATITUDE = 53.339428
    private const val DUBLIN_OFFICE_LONGITUDE = -6.257664
    val DUBLIN_OFFICE_LOCATION = Location(DUBLIN_OFFICE_LATITUDE, DUBLIN_OFFICE_LONGITUDE)

    // TODO : Ideally this should be an xml configurable path
    const val CUSTOMERS_FILE_PATH = "customers.json"
}