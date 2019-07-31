package scZoo

import scZoo.controllers.AnimalRelationships
import scZoo.model.Zoo

object ZooMain {
    val zoo = Zoo()
    init {
        println("Welcome to this little Zoo excercise")
    }
    fun showAnimals() {
        println("These are the current animals with their friends")
        println(zoo.animals)
        println()
    }
    fun liveOneDay() {
        println("A new living day is starting...")
        AnimalRelationships.liveOneDay(zoo.animals)
        println("Living day relationships change finished.\r\n")
    }
    fun runMenu() {
        while (true) {
            println("Main Menu, press:")
            println("1 -> Show animal list along their current friends")
            println("2 -> Live one day and see friendships change")
            println("3 -> Exit program")
            println("")
            var choice: String?
            do {
                print("Your choice: ")
                choice = readLine();
                when (choice) {
                    "1" -> showAnimals()
                    "2" -> liveOneDay()
                    "3" -> {
                        println("Program terminated")
                        return
                    }
                    else -> println("Unsupported choice \"$choice\"")
                }
            } while (choice != "1" && choice != "2")
            println("Press return to continue..")
            System.`in`.read()
        }
    }
}

fun main() {
    ZooMain.runMenu()
}