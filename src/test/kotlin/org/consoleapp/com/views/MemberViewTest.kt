package org.consoleapp.com.views

import org.consoleapp.com.models.MemberModel
import org.junit.Assert
import org.junit.Test

class MemberViewTest {
    var aMember = MemberModel(90,"manzi joseph","tramore","underweight","man@i.com","male")

    @Test
    fun addMemberData() {
        Assert.assertEquals(addMemberData(this.aMember),"true")

    }
}