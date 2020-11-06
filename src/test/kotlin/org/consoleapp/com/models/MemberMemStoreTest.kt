package org.consoleapp.com.models
import org.junit.Assert
import org.junit.Test

class MemberMemStoreTest {
    var member = MemberModel(90,"manzi joseph","tramore","underweight","man@i.com","male")

    @Test
    fun create(m: MemberModel) {
        Assert.assertEquals(create(member),"Member Created")

    }

    @Test
    fun update(member: MemberModel){
        
    }
}



