package com.rs.intercom.repository.models

import com.fasterxml.jackson.annotation.JsonProperty

internal data class Location(
    @JsonProperty("latitude") val latitude: Double,
    @JsonProperty("longitude") val longitude: Double
)