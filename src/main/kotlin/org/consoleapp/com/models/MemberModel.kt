package org.consoleapp.com.models

data class MemberModel(
    var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var dateOfBirth : String = "",
    //var dateOfBirth: LocalDate = LocalDate.parse("2020-01-10", DateTimeFormatter.ISO_DATE),
    var email: String = "",
    var phoneNumber: String = ""
)

//import javafx.beans.property.SimpleIntegerProperty
//import javafx.beans.property.SimpleStringProperty
//import tornadofx.*
//
//class Member(id: Int, firstName: String, lastName: String, dateOfBirth: String,
//                  email: String, phoneNumber: String) {
//    val idProperty = SimpleIntegerProperty(id)
//    var id by idProperty
//
//    var id: Int = 1000
//
//    val firstNameProperty = SimpleStringProperty( firstName)
//    var firstName by firstNameProperty
//
//    val lastNameProperty = SimpleStringProperty(lastName)
//    var lastName by lastNameProperty
//
//    val dateOfBirthProperty = SimpleStringProperty(dateOfBirth)
//    var dateOfBirth by dateOfBirthProperty
//
//    val emailProperty = SimpleStringProperty(email)
//    var email by emailProperty
//
//    val phoneNumberProperty = SimpleStringProperty(phoneNumber)
//    var phoneNumber by phoneNumberProperty
//}
//
//class MemberModel: ItemViewModel<Member>() {
////    var id = bind(Member::idProperty)
//    var id = 1000
//    val firstName = bind(Member::firstNameProperty)
//    val lastName = bind(Member::lastNameProperty)
//    val dateOfBirth = bind(Member::dateOfBirthProperty)
//    val email = bind(Member::emailProperty)
//    val phoneNumber = bind(Member::phoneNumberProperty)
//}
//
//class MemberScope:  Scope() {
//    val model = MemberModel()
//}
//
//
