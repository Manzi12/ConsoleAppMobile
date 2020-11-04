package org.consoleapp.com.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.consoleapp.com.controllers.MemberUIController
import tornadofx.*

class MenuScreen : View("Member Main Menu") {

    val memberUIController: MemberUIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Members") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        memberUIController.loadAddScreen()
                    }
                }
            }
            text("")
            button("List Members") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        memberUIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Update Members Details") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        memberUIController.loadUpdateScreen()
                    }
                }
            }

            text("")
            button("Delete Members") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        memberUIController.loadDeleteScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }
        }

    }


}