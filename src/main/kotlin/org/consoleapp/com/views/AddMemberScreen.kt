package org.consoleapp.com.views

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.consoleapp.com.controllers.MemberUIController
import tornadofx.*

class AddMemberScreen: View("Add Member") {
    val model = ViewModel()
    val _firstName = model.bind { SimpleStringProperty() }
    val _lastName = model.bind { SimpleStringProperty() }
    val _dateOfBirth = model.bind { SimpleStringProperty() }
    val _email = model.bind { SimpleStringProperty() }
    val _phoneNumber = model.bind {SimpleStringProperty()  }
    val memberUIController: MemberUIController by inject()

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("First Name") {
                textfield(_firstName).required()
            }
            field("Last Name") {
                textarea(_lastName).required()
            }
            field("Date Of Birth") {
                textfield(_dateOfBirth).required()
            }
            field("Email") {
                textarea(_email).required()
            }
            field("Phone Number") {
                textarea(_phoneNumber).required()
            }
            button("Add") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        memberUIController.add(_firstName.toString(),
                        _lastName.toString(),
                        _phoneNumber.toString(),
                        _email.toString(),
                        _phoneNumber.toString())

                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        memberUIController.closeAdd()
                    }
                }
            }
        }
    }

    override fun onDock() {
        _firstName.value = ""
        _lastName.value = ""
        _dateOfBirth.value = ""
        _email.value = ""
        _phoneNumber.value = ""
        model.clearDecorators()
    }

}