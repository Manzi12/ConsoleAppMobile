package org.consoleapp.com.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class MemberMemStore: MemberStore {
    val members = ArrayList<MemberModel>()

    override fun findAll() : List<MemberModel>{
        return members
    }

    override fun findOne(id: Long) : MemberModel?{
        var foundMember: MemberModel? = members.find { m -> m.id == id }
        return foundMember
    }

    override fun create(member: MemberModel) {
        member.id = getId()
        members.add(member)
        logAll()
    }

    override fun update(member: MemberModel) {
        var foundMember = findOne(member.id!!)
        if(foundMember != null){
            foundMember.firstName = member.firstName
            foundMember.lastName = member.lastName
            foundMember.dateOfBirth = member.dateOfBirth
            foundMember.email = member.email
            foundMember.phoneNumber = member.phoneNumber
        }
    }

    internal fun logAll(){
        members.forEach { logger.info ("${it}")}
    }
}