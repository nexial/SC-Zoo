package scZoo.controllers

import scZoo.model.Animal
import scZoo.model.IAnimalSet
import kotlin.random.Random

object AnimalRelationships {
    private const val loseFriendshipChance = 50;
    private fun randomBreakFriendship(animal: Animal): Animal? {
        if (Random.nextInt(99) < loseFriendshipChance)
            return null
        val exFriendIndex = Random.nextInt(animal.friends.count())
        val exFriend = animal.friends[exFriendIndex]
        return if (animal.breakFriendship(exFriend))
            exFriend
        else
            null
    }
    private fun randomMakeFriendship(animal: Animal, allAnimals: Array<Animal>): Animal?
    {
        val newFriendIndex = Random.nextInt(allAnimals.size - 1)
        val newFriend = allAnimals[newFriendIndex]
        return if (animal.makeFriendship(newFriend))
            newFriend
        else
            null
    }
    fun liveOneDay(sourceAnimals: IAnimalSet) {
        println("A new living day is starting...")
        val localAnimalsArray = sourceAnimals.toArray()
        for (animal in localAnimalsArray) {
            val exFriend = randomBreakFriendship(animal)
            val newFriend = randomMakeFriendship(animal, localAnimalsArray)
            if (exFriend == newFriend) {
                if ((exFriend !== null))
                    println("${animal.name} and ${exFriend.name} had a serious discussion but at the end they are still friends.")
                continue
            }
            if (exFriend !== null)
                println("${animal.name} and ${exFriend.name} are no longer friends.")
            if (newFriend !== null)
                println("${animal.name} and ${newFriend.name} are no longer friends.")
        }
        println("Living day relationships change finished.\r\n")
    }
}