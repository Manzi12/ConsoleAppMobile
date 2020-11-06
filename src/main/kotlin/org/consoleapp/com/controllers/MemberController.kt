package org.consoleapp.com.controllers

import mu.KotlinLogging
import org.consoleapp.com.models.MemberJSONStore
import org.consoleapp.com.models.MemberModel
import org.consoleapp.com.views.MemberView


class MemberController {
    //val members = MemberMemStore()
    private val members = MemberJSONStore()
    private val memberView = MemberView()
    private val logger = KotlinLogging.logger {}

    init {
        logger.info {"Launching LOCAL GYM APP Console APP"}
        println("Local Gym App Version 1.0")
    }

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

    private fun menu() : Int {
        return memberView.menu()
    }

    private fun add(){
        var aMember = MemberModel()

        if(memberView.addMemberData(aMember))
            members.create(aMember)
        else
            logger.info("Members Not Added")
    }

    private fun list(){
        memberView.listMembers(members)
    }

    private fun update(){
        memberView.listMembers(members)
        var searchId = memberView.getId()
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

    private fun delete(){
        memberView.listMembers(members)
        var searchId = memberView.getId()
        val aMember = search(searchId)

        if(aMember != null){
            members.delete(aMember)
            println("Member Deleted....")
            memberView.listMembers(members)
        }
        else
            println("Member Not Deleted....")
    }

    private fun search(){
        val aMember = search(memberView.getId())!!
        memberView.showMembers(aMember)
    }

    private fun search(id: Int) : MemberModel?{
        return members.findOne(id)
    }

    private fun dummyData(){
        members.create(MemberModel(1000,"Manzi","Joseph","1790-10-19","manzi@man","09856"))
        members.create(MemberModel(1200,"Frank","Joseph","1790-10-19","frank@man","09328"))
        members.create(MemberModel(1300,"James","Joseph","1790-10-19","james@man","09438"))
        members.create(MemberModel(1400,"Hannah","Joseph","1790-10-19","hannah@man","09128"))
    }
}