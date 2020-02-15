package com.rs.intercom

import com.rs.intercom.helpers.Constants.CUSTOMERS_FILE_PATH
import com.rs.intercom.helpers.Constants.CUSTOMER_DISTANCE_KM_DEFAULT
import com.rs.intercom.helpers.Constants.DUBLIN_OFFICE_LOCATION
import com.rs.intercom.helpers.sortByID
import com.rs.intercom.helpers.writeToFile
import com.rs.intercom.repository.CustomerStore
import com.rs.intercom.repository.Repository


fun main() {
    val result =
        CustomerStore.listNearByCustomers(
            CUSTOMERS_FILE_PATH,
            DUBLIN_OFFICE_LOCATION,
            CUSTOMER_DISTANCE_KM_DEFAULT
        ).sortByID()

    println("Invitations needs to be sent to :::: \n")
    println("USER ID  NAME")
    result.forEach { println("${it.userId} \t ${it.name}") }
    Repository.convertToJSONStr(result).writeToFile("output.txt")
    println("\n The invites list is also written to output.json file")

}