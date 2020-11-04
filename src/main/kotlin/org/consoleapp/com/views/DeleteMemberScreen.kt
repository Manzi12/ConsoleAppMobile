package org.consoleapp.com.views

import javafx.scene.control.SelectionMode
import org.consoleapp.com.controllers.MemberUIController
import org.consoleapp.com.models.MemberModel
import tornadofx.*


class DeleteMemberScreen: View("List Members"){
    val memberUIController: MemberUIController by inject()
    val tableContent = memberUIController.members.findAll()
    val data = tableContent.observable()

    override val root = vbox {
        setPrefSize(650.0, 200.0)
        tableview(data) {
            column("ID", MemberModel::id).fixedWidth(100)
            column("FIRSTNAME", MemberModel::firstName).fixedWidth(100)
            column("LASTNAME", MemberModel::lastName).fixedWidth(100)
            column("DATE OF BIRTH", MemberModel::dateOfBirth).fixedWidth(100)
            column("EMAIL", MemberModel::email).fixedWidth(120)
            column("PHONE NUMBER", MemberModel::phoneNumber).fixedWidth(130)

            selectionModel.selectionMode = SelectionMode.SINGLE
            onUserSelect {member ->
                var memberID = member.id
                memberUIController.delete(memberID)
            }
        }

        button("Delete") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    memberUIController.closeDelete()
                }
            }
        }

    }

}