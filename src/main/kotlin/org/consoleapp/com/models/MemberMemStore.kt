package org.consoleapp.com.models

import mu.KotlinLogging

/**
 * @author Manzi Joseph
 *
 */

private val logger = KotlinLogging.logger {}
var lastId = 1000

internal fun getId(): Int {
    return lastId++
}

class MemberMemStore: MemberStore {
    private val members = ArrayList<MemberModel>()

    override fun findAll() : List<MemberModel>{
        return members
    }

    // overrides the findOne abstract function and implement the class function
    override fun findOne(id: Int) : MemberModel?{
        return members.find { m -> m.id == id }
    }

    // overrides the create abstract function and implement the class function
    override fun create(member: MemberModel) {
        member.id = getId()
        members.add(member)
        logAll()
    }

    // overrides the update abstract function and implement the class function
    override fun update(member: MemberModel) {
        val foundMember = findOne(member.id)
        if(foundMember != null){
            foundMember.fullName = member.fullName
            foundMember.memberAddress = member.memberAddress
            foundMember.BMICategory = member.BMICategory
            foundMember.email = member.email
            foundMember.gender = member.gender
        }
    }

    // overrides the delete abstract function and implement the class function
    override fun delete(member: MemberModel) {
        val foundMember = findOne(member.id)
        if(foundMember != null){
            members.remove(foundMember)
        }
    }

    // function to display all the members
    internal fun logAll(){
        members.forEach { logger.info ("$it")}
    }
}