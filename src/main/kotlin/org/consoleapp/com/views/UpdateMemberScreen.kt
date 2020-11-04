package org.consoleapp.com.views

import javafx.scene.control.SelectionMode
import org.consoleapp.com.controllers.MemberUIController
import org.consoleapp.com.models.MemberModel
import tornadofx.*


class UpdateMemberScreen: View("List Members"){
    val memberUIController: MemberUIController by inject()
    val tableContent = memberUIController.members.findAll()
    val data = tableContent.observable()

    var _firstName: String = ""
    var _lastName: String = ""
    var _dateOfBirth: String = ""
    var _email: String = ""
    var _phoneNum: String = ""
    //var member : MemberModel()


    override val root = vbox {
        setPrefSize(650.0, 200.0)
        tableview(data) {
            column("ID", MemberModel::id).fixedWidth(100)
            column("FIRSTNAME", MemberModel::firstName).fixedWidth(100).makeEditable()
            column("LASTNAME", MemberModel::lastName).fixedWidth(100).makeEditable()
            column("DATE OF BIRTH", MemberModel::dateOfBirth).fixedWidth(100).makeEditable()
            column("EMAIL", MemberModel::email).fixedWidth(120).makeEditable()
            column("PHONE NUMBER", MemberModel::phoneNumber).fixedWidth(130).makeEditable()

            selectionModel.selectionMode = SelectionMode.SINGLE
            onUserSelect {member ->
                print(member)
            }
        }

        button("Update") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    memberUIController.closeUpdate()
                }
            }
        }

    }

}