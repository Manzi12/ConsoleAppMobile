package org.consoleapp.com.controllers

import mu.KotlinLogging
import org.consoleapp.com.models.MemberJSONStore
import org.consoleapp.com.models.MemberMemStore
import org.consoleapp.com.models.MemberStore
import org.consoleapp.com.models.MemberModel
import org.consoleapp.com.views.MemberView


class MemberController {
    //val members = MemberMemStore()
    val members = MemberJSONStore()
    val memberView = MemberView()
    val logger = KotlinLogging.logger {}

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
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        }while (input!=-1)
        logger.info("Shutting Down Gym Console App")
    }

    fun menu() : Int {
        return memberView.menu()
    }

    fun add(){
        var aMember = MemberModel()

        if(memberView.addMemberData(aMember))
            members.create(aMember)
        else
            logger.info("Members Not Added")
    }

    fun list(){
        memberView.listMembers(members)
    }

    fun update(){
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

    fun delete(){
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

    fun search(){
        val aMember = search(memberView.getId())!!
        memberView.showMembers(aMember)
    }

    fun search(id: Long) : MemberModel?{
        var foundMember = members.findOne(id)
        return foundMember
    }

    fun dummyData(){
        members.create(MemberModel(10L,"Manzi","Joseph","09/10/90","manzi@man","09856"))
        members.create(MemberModel(11L,"Frank","Joseph","09/10/2023","frank@man","09328"))
        members.create(MemberModel(12L,"James","Joseph","09/10/2025","james@man","09438"))
        members.create(MemberModel(13L,"Hannah","Joseph","09/10/2022","hannah@man","09128"))
    }
}