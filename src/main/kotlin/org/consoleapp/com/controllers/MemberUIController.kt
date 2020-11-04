package org.consoleapp.com.controllers

import mu.KotlinLogging
import org.consoleapp.com.models.MemberJSONStore
import org.consoleapp.com.models.MemberModel
import org.consoleapp.com.views.*
import tornadofx.*
import java.time.LocalDate

class MemberUIController: Controller() {
    val members = MemberJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Gym TornadoFX UI App" }
    }

    fun add(_firstName: String, _lastName: String, _dateOfBirth: String, _email: String, _phoneNumber: String) {

        var aMember = MemberModel(
            firstName = _firstName,
            lastName = _lastName,
            dateOfBirth = _dateOfBirth,
            email = _email,
            phoneNumber = _phoneNumber
        )
        members.create(aMember)
        logger.info("Member Added")
    }

    fun update(_firstName: String, _lastName: String, _dateOfBirth: String, _email: String, _phoneNumber: String) {

        var aMember = MemberModel(
            firstName = _firstName,
            lastName = _lastName,
            dateOfBirth = _dateOfBirth,
            email = _email,
            phoneNumber = _phoneNumber
        )
        members.update(aMember)
        logger.info("Member Updated")
    }

    fun delete(_memberID: Int) {

        var aMember = MemberModel(
            id = _memberID,
        )
        members.delete(aMember)
        logger.info("Member Deleted")
    }

    fun loadListScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListMemberScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        members.logAll()
    }

    fun loadAddScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddMemberScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadUpdateScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(UpdateMemberScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadDeleteScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(DeleteMemberScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAdd() {
        runLater {
            find(AddMemberScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeDelete() {
        runLater {
            find(DeleteMemberScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeUpdate() {
        runLater {
            find(UpdateMemberScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

        fun closeList() {
            runLater {
                find(ListMemberScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
            }
        }
}