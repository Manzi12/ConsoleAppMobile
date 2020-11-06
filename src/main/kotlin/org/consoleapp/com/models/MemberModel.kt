package org.consoleapp.com.models

// this is the data class
data class MemberModel(
    var id: Int = 0,
    var fullName: String = "",
    var memberAddress: String = "",
    var BMICategory : String = "",
    var email: String = "",
    var gender: String = ""
)
