package org.consoleapp.com.models

data class MemberModel(var id: Long = 0,
                       var firstName: String = "",
                       var lastName: String = "",
                       var dateOfBirth: String = "",
                       var email: String = "",
                       var phoneNumber: String = ""
)