package org.consoleapp.com

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    logger.info { "Launching Task Scheduling Console App" }
    println("Task Scheduling Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addTask()
            2 -> updateTask()
            3 -> listTasks()
            4 -> deleteTask()
            5 -> tastStats()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Task Scheduling Console App" }
}

fun menu() : Int {

    val option : Int
    var input: String? = null


    println("MAIN MENU")
    println(" 1. Add Task")
    println(" 2. Update Task")
    println(" 3. List All Tasks")
    println(" 4. Delete Task")
    println(" 5. Tasks Statistics")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && input.isNotEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addTask(){
    println("You Chose Add Task")
}

fun updateTask() {
    println("You Chose Update Task")
}

fun listTasks() {
    println("You Chose List All Tasks")
}

fun deleteTask(){
    println("you chose detele task")
}

fun tastStats(){
    println("you chose Task Statistics")
}