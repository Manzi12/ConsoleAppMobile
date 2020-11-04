package org.consoleapp.com.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class MemberModel(
    var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var dateOfBirth : String = "",
    //var dateOfBirth: LocalDate = LocalDate.parse("2020-01-10", DateTimeFormatter.ISO_DATE),
    var email: String = "",
    var phoneNumber: String = ""
)