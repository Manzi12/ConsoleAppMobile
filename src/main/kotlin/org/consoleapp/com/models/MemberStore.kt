package org.consoleapp.com.models

interface MemberStore {
    fun findAll(): List<MemberModel>
    fun findOne(id: Long) : MemberModel?
    fun create(member: MemberModel)
    fun update(member: MemberModel)
}
