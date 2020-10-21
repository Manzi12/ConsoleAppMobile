package org.consoleapp.com.main

import mu.KotlinLogging
import org.consoleapp.com.models.MemberModel

private val logger = KotlinLogging.logger {}
val Members = ArrayList<MemberModel>()

fun main() {
    logger.info { "Launching Local Gym Console App" }
    println("Local Gym Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addMember()
            2 -> updateMemberDetails()
            3 -> listAllMembers()
            4 -> deleteMEmber()
            //5 -> tastStats()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Local Gym Console App" }
}

fun menu() : Int {

    val option : Int
    var input: String? = null


    println("MAIN MENU")
    println(" 1. Add Member")
    println(" 2. Update Member Details")
    println(" 3. List All Members")
    println(" 4. Delete Member")
    //println(" 5. Tasks Statistics")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && input.isNotEmpty())
        input.toInt()
    else
        0
    return option
}

fun addMember(){
    var aMember = MemberModel()
    
    println("Add Member")
    println()
    println("Enter First Name")
    aMember.firstName = readLine()!!
    println("Enter Last Name")
    aMember.lastName = readLine()!!
    println("Enter Your date of birth (dd/mm/yyyy)")
    aMember.dateOfBirth = readLine()!!
    println("Enter Your Email ")
    aMember.email = readLine()!!
    println("Enter Your Phone Number (0123456789) ")
    aMember.phoneNumber = readLine()!!

    if(aMember.firstName.isNotEmpty() && aMember.email.isNotEmpty()){
        aMember.id = Members.size.toLong()
        Members.add(aMember.copy())
        logger.info("Member Added : [ $aMember ]")
    }else{
        logger.info ("Member Not Added")
    }

}


fun updateMemberDetails() {
    println("Update Member details")
    println()
    listAllMembers()
    var searchID = getID()
    val aMember = search(searchID)

    if (aMember != null){
        print("Enter first name for ${aMember.firstName} : ")
        aMember.firstName = readLine()!!
        print("Enter last name for ${aMember.lastName} : ")
        aMember.lastName = readLine()!!
        print("Enter date of birth for ${aMember.dateOfBirth} : ")
        aMember.dateOfBirth = readLine()!!
        print("Enter email for ${aMember.email} : ")
        aMember.email = readLine()!!
        print("Enter phone number for ${aMember.phoneNumber} : ")
        aMember.phoneNumber = readLine()!!
        println(
            "You updated [" + aMember.firstName + "] for first name\n " +
            "You updated [" + aMember.lastName + "] for last name\n " +
            "You updated [" + aMember.dateOfBirth + "] for dateOfBirth\n " +
            "You updated [" + aMember.email + "] for email\n " +
            "You updated [" + aMember.firstName + "] for title\n"
        )
    }else{
        println("Member not Updated")
    }
}

fun listAllMembers() {
    println("List All Members")
    println()
    Members.forEach { logger.info ("${it}")}
}

fun searchMember(){
    var searchID = getID()
    var aMember = search(searchID)

    if(aMember != null)
        println("Member Details [$aMember]")
    else
        println("Member not found")
}

fun getID() : Long {
    var strID : String?
    var searchID : Long

    print("Enter id to Search/Update : ")
    strID = readLine()!!
    searchID = if (strID.toLongOrNull() != null && !strID.isEmpty())
        strID.toLong()
    else
        0
    return searchID
}

fun search(id : Long) : MemberModel? {
    var foundMember : MemberModel? = Members.find { p -> p.id == id }
    return foundMember
}



fun deleteMEmber(){
    println("Detele Members")
    var id: Long
    id = getID()
    if (Members != null){
        Members.remove(id)
        println("Member deleted")
    }else{
        println("Erro Member Not Deleted")
    }
}

fun dummyData(){
    Members.add(MemberModel(10,"Manzi","Joseph","09/10/90","manzi@man","09856"))
    Members.add(MemberModel(11,"Frank","Joseph","09/10/2023","frank@man","09328"))
    Members.add(MemberModel(12,"James","Joseph","09/10/2025","james@man","09438"))
    Members.add(MemberModel(13,"Hannah","Joseph","09/10/2022","hannah@man","09128"))
}