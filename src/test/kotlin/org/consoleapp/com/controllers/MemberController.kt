package org.consoleapp.com.controllers

import org.consoleapp.com.models.MemberModel
import org.junit.Assert
import org.junit.Test
import org.junit.Assert.assertArrayEquals

class MemberController {


    var aMember = MemberModel(90,"manzi joseph","tramore","underweight","man@i.com","male")

    @Test
    fun addMember(aMember: MemberModel) {
        Assert.assertEquals(addMember(this.aMember),"true")

    }

    @Test
    fun search(id: Int){
        Assert.assertEquals((aMember.id==90),"true")
    }
}