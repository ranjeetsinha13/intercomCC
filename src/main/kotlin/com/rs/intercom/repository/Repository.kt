package com.rs.intercom.repository

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.rs.intercom.helpers.Logger
import com.rs.intercom.helpers.getFileData
import com.rs.intercom.repository.models.Customer
import com.rs.intercom.repository.models.Location
import java.io.IOException
import java.lang.NumberFormatException

internal object Repository {

    private const val TAG = "Repository"

    private val objectMapper by lazy {
        ObjectMapper()
    }

    @Throws(JsonProcessingException::class, JsonMappingException::class)
    fun convertToJSONStr(customersList: List<Customer>): String = objectMapper.writeValueAsString(customersList)

    fun listOfCustomers(filePath: String): List<Customer>? {
        return try {
            listOfCustomers(filePath.getFileData())
        } catch (ex: IOException) {
            Logger.logE(TAG, "${ex.localizedMessage}")
            listOf()
        }
    }

    private fun listOfCustomers(customerData: List<String?>?): List<Customer>? {
        val customerList = mutableListOf<Customer>()
        customerData?.let {
            for (customerStr in customerData) {
                customerStr?.let {
                    try {
                        val customer = objectMapper.readValue<Customer>(it, Customer::class.java)
                        customerList.add(customer)
                    } catch (ex: JsonParseException) {
                        Logger.logE(TAG, "${ex.localizedMessage}")
                    } catch (ex: JsonMappingException) {
                        Logger.logE(TAG, "${ex.localizedMessage}")
                    } catch (ex: IOException) {
                        Logger.logE(TAG, "${ex.localizedMessage}")
                    }
                }
            }
        }
        return customerList
    }
}

internal object CustomerStore {

    private const val TAG = "CustomerStore"

    fun listNearByCustomers(filePath: String, center: Location, distance: Double): List<Customer> {
        val allCustomers = Repository.listOfCustomers(filePath)
        val customersWinInRange = mutableListOf<Customer>()
        allCustomers?.let {
            for (customer in it) {
                val location = mapLocationFromLatLong(customer.latitude, customer.longitude)
                try {
                    if (center.isWithInRange(location, distance)) {
                        customersWinInRange.add(customer)
                    } else {
                        Logger.logD(TAG, "Customer ${customer.userId} is not in Range")
                    }
                } catch (ex: NumberFormatException) {
                    Logger.logE(TAG, "Customer ${customer.userId} location has errors : ${ex.localizedMessage}")
                }
            }
            return customersWinInRange
        }
        return emptyList()
    }

    @Throws(NumberFormatException::class)
    private fun mapLocationFromLatLong(latitude: String, longitude: String): Location =
        Location(latitude.toDouble(), longitude.toDouble())
}