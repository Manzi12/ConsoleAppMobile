package org.consoleapp.com.controllers

import mu.KotlinLogging
import org.consoleapp.com.models.MemberJSONStore
import org.consoleapp.com.models.MemberModel
import org.consoleapp.com.views.MemberView

/**
 * @author Manzi Joseph
 */

class MemberController {
    //val members = MemberMemStore()
    private val members = MemberJSONStore()
    private val memberView = MemberView()
    private val logger = KotlinLogging.logger {}

    init {
        logger.info {"Launching LOCAL GYM APP Console APP"}
        println("Local Gym App Version 1.0")
    }

    // the function that gets called to start the whole program
    fun start(){
        var input : Int

        do {
            input = menu()
            when(input){
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                -99 -> dummyData()
                100 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        }while (input!=-1)
        logger.info("Shutting Down Gym Console App")
    }

    // the menu function that displays the menu
    private fun menu() : Int {
        return memberView.menu()
    }

    // the add function allow the user to add a member
    private fun add(){
        val aMember = MemberModel()

        if(memberView.addMemberData(aMember)) {
            members.create(aMember)
            logger.info("Member Added Successfully")
        }
        else
            logger.info("Members Not Added, Please check that you have filled all fields")
    }

    // list members function
    private fun list(){
        memberView.listMembers(members)
    }

    // update members function
    private fun update(){
        memberView.listMembers(members)
        val searchId = memberView.getId()
        val aMember = search(searchId)

        if(aMember != null){
            if(memberView.updateMemberData(aMember)){
                members.update(aMember)
                memberView.showMembers(aMember)
                logger.info("Member Updated : [$aMember]")
            }else
                logger.info("Member Not Added")
        }else
            println("Member Not Added")
    }

    // delete members function
    private fun delete(){
        memberView.listMembers(members)
        val searchId = memberView.getId()
        val aMember = search(searchId)

        if(aMember != null){
            members.delete(aMember)
            println("Member Deleted....")
            memberView.listMembers(members)
        }
        else
            println("Member Not Deleted....")
    }

    // search members  function
    private fun search(){
        val aMember = search(memberView.getId())!!
        memberView.showMembers(aMember)
    }

    // search members id function
    private fun search(id: Int) : MemberModel?{
        return members.findOne(id)
    }

    // just some dummy data just in case
    private fun dummyData(){
        members.create(MemberModel(1000,"Luther Joseph","Waterford","Obese","09856","Male"))
        members.create(MemberModel(1200,"Frank Manda","Dublin","Very Obese","09328", "Male"))
        members.create(MemberModel(1300,"James wilson","Cork","Moderately Underweight","09438","Male"))
        members.create(MemberModel(1400,"Hannah House" ,"London","UnderWeight","09128","Male"))
    }
}