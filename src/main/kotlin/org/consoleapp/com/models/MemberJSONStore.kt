package org.consoleapp.com.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
import org.consoleapp.com.helpers.exists
import org.consoleapp.com.helpers.read
import org.consoleapp.com.helpers.write
import java.util.ArrayList
import kotlin.random.Random


private val logger = KotlinLogging.logger {}

val JSON_FILE = "members.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<ArrayList<MemberModel>>() {}.type

fun generateRandomId(): Long {
    return Random.nextLong()
}


class MemberJSONStore : MemberStore {
    var members = mutableListOf<MemberModel>()

    init {
        if(exists(JSON_FILE)){
            deserialize()
        }
    }

    override fun findAll(): MutableList<MemberModel> {
        return members
    }

    override fun findOne(id: Long): MemberModel? {
        var foundMember : MemberModel? = members.find { m -> m.id == id }
        return foundMember
    }

    override fun create(member: MemberModel) {
        member.id = generateRandomId()
        members.add(member)
        serialize()
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
        serialize()
    }

    internal fun logAll(){
        members.forEach { logger.info("${it}")}
    }

    private fun serialize(){
        var jsonString = gsonBuilder.toJson(members, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize(){
        val jsonString = read(JSON_FILE)
        members = Gson().fromJson(jsonString, listType)
    }

}