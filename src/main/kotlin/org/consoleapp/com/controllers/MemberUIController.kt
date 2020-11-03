package org.consoleapp.com.controllers

import mu.KotlinLogging
import org.consoleapp.com.models.MemberJSONStore
import org.consoleapp.com.models.MemberModel
import org.consoleapp.com.views.MenuScreen
import tornadofx.*

class MemberUIController: Controller() {
    val members = MemberJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Gym TornadoFX UI App" }
    }
    fun add(_firstName : String, _lastName : String, _dateOfBirth : String, _email : String, _phoneNumber : String){

        var aMember = MemberModel(firstName = _firstName, lastName = _lastName, dateOfBirth = _dateOfBirth, email = _email, phoneNumber = _phoneNumber)
        members.create(aMember)
        logger.info("Member Added")
    }

    fun loadListScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListPlacemarkScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        members.logAll()

}