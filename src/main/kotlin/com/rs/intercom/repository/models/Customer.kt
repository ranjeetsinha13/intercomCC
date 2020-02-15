package com.rs.intercom.repository.models

import com.fasterxml.jackson.annotation.JsonProperty

internal data class Customer(
    @JsonProperty("user_id") val userId: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("latitude") val latitude: String,
    @JsonProperty("longitude") val longitude: String
)