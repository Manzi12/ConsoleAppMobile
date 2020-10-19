package org.consoleapp.com.main

import mu.KotlinLogging
import org.consoleapp.com.models.MemberModel

private val logger = KotlinLogging.logger {}
val tasks = ArrayList<MemberModel>()

fun main() {
    logger.info { "Launching Local Gym Console App" }
    println("Task Scheduling Kotlin App Version 1.0")

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
        -9
    return option
}

fun addMember(){
    var aMember = MemberModel()
    
    println("Add Task")
    println()
    println("Please Enter First Name")
    aMember.memberFName = readLine()!!
    println("Enter Enetr Last Name")
    aMember.memberLName = readLine()!!
    println("Enter Your age ")
    aMember.address = readLine()!!

}


fun updateMemberDetails() {
    println("You Chose Update Member details")
}

fun listAllMembers() {
    println("You Chose List All Members")
}

fun deleteMEmber(){
    println("you chose detele Members")
}