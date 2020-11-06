package org.consoleapp.com.views

import org.consoleapp.com.models.MemberJSONStore
import org.consoleapp.com.models.MemberMemStore
import org.consoleapp.com.models.MemberModel
import org.consoleapp.com.models.MemberStore
import java.io.Console
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern

/**
 * @author Manzi Joseph
 */

class MemberView {
    // menu function interact with the user
    fun menu(): Int{
        var option : Int
        var input: String?

        println("LOCAL GYM APP MAIN MENU")
        println(" 1. Add Member")
        println(" 2. Update Member Details")
        println(" 3. List All Members")
        println(" 4. Search Member")
        println(" 5. Delete Member")
        println(" -99. Dummy Data")
        println(" 100. Exit")
        println()
        print("Enter an Option : ")
        input = readLine()!!
        option = if(input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            100
        return option
    }


    // lsit function displays the members list not persisited
    fun listMembers(members : MemberMemStore){
        println("List All Members")
        println()
        members.logAll()
        println()
    }

    // lsit function displays the members list  persisited
    fun listMembers(members : MemberJSONStore){
        println("List All Members")
        println()
        members.logAll()
        println()
    }

    // lsit function allows you to add a member
    fun addMemberData(member : MemberModel) : Boolean{
        println()
        print("Enter your full name : ")
        member.fullName = readLine()!!
        print("Enter your Address: ")
        member.memberAddress = readLine()!!
        print("Tell us your BMI Category : ")
        member.BMICategory = readLine()!!
        print("Enter Your Email: ")
        member.email = readLine()!!
        print("Enter Your Gender (Male/Female): ")
        member.gender = readLine()!!
        return member.fullName.isNotEmpty() &&
                member.memberAddress.isNotEmpty() &&
                member.BMICategory.isNotEmpty() &&
                member.email.isEmailValid()
    }

    // this function displays the member details
    fun showMembers(member : MemberModel){
        println("Member Details [$member]")
    }

    // this functions enables the member to update details
    fun updateMemberData(member: MemberModel) : Boolean{
        var tempFName : String?
        var tempMAddress : String?
        var tempBmiCat : String?
        var tempEmail : String?
        var tempGender : String?

        print("Enter a new full name for [ " + member.fullName + " ] : ")
        tempFName = readLine()!!
        print("Enter a new address for [ " + member.memberAddress + " ] : ")
        tempMAddress = readLine()!!
        print("Enter a new BMI Category [ " + member.BMICategory + " ] : ")
        tempBmiCat = readLine()!!
        print("Enter a new email for [ " + member.email + " ] : ")
        tempEmail = readLine()!!
        print("Enter a new Gender for [ " + member.gender + " ] : ")
        tempGender = readLine()!!

        if(!tempFName.isNullOrEmpty() && !tempEmail.isNullOrEmpty()){
            member.fullName = tempFName
            member.memberAddress = tempMAddress
            member.BMICategory = tempBmiCat
            member.email = tempEmail
            member.gender = tempGender
            return true
        }
        return false
    }

    // function used to get an id used for searching and deleting
    fun getId() : Int{
        var strId : String?     // string to hold user input
        var searchId : Int     // Long to hold converted id
        print("Enter Id to search/update : ")
        strId = readLine()!!
        searchId = if(strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toInt()
        else
            -9
        return searchId
    }

    // function used to validate the email pattern. if not valid member wont be added
    fun String.isEmailValid(): Boolean{
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }
}