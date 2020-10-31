package org.consoleapp.com.views

import org.consoleapp.com.models.MemberJSONStore
import org.consoleapp.com.models.MemberMemStore
import org.consoleapp.com.models.MemberModel
import org.consoleapp.com.models.MemberStore
import java.util.regex.Pattern

class MemberView {
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


    fun listMembers(members : MemberMemStore){
        println("List All Members")
        println()
        members.logAll()
        println()
    }

    fun listMembers(members : MemberJSONStore){
        println("List All Members")
        println()
        members.logAll()
        println()
    }

    fun addMemberData(member : MemberModel) : Boolean{
        println()
        print("Enter your first name : ")
        member.firstName = readLine()!!
        print("Enter Last Name: ")
        member.lastName = readLine()!!
        print("Enter Your date of birth (dd/mm/yyyy) : ")
        member.dateOfBirth = readLine()!!
        print("Enter Your Email: ")
        member.email = readLine()!!
        print("Enter Your Phone Number (0123456789): ")
        member.phoneNumber = readLine()!!
        return member.firstName.isNotEmpty() && member.email.isNotEmpty()
    }

    fun showMembers(member : MemberModel){
        if(member != null)
            println("Member Details [$member]")
        else
            print("Member not found")
    }

    fun updateMemberData(member: MemberModel) : Boolean{
        var tempFName : String?
        var tempLName : String?
        var tempDob : String?
        var tempEmail : String?
        var tempPnum : String?

        if(member != null) {
            print("Enter a new first name for [ " + member.firstName + " ] : ")
            tempFName = readLine()!!
            print("Enter a new last name for [ " + member.lastName + " ] : ")
            tempLName = readLine()!!
            print("Enter a new date of birth for [ " + member.dateOfBirth + " ] : ")
            tempDob = readLine()!!
            print("Enter a new email for [ " + member.email + " ] : ")
            tempEmail = readLine()!!
            print("Enter a new Phone number for [ " + member.phoneNumber + " ] : ")
            tempPnum = readLine()!!

            if(!tempFName.isNullOrEmpty() && !tempEmail.isNullOrEmpty()){
                member.firstName = tempFName
                member.lastName = tempLName
                member.dateOfBirth = tempDob
                member.email = tempEmail
                member.phoneNumber = tempPnum
                return true
            }
        }
        return false
    }

    fun getId() : Long{
        var strId : String?     // string to hold user input
        var searchId : Long     // Long to hold converted id
        print("Enter Id to search/update")
        strId = readLine()!!
        searchId = if(strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

    fun String.isEmailValid(): Boolean{
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }
}