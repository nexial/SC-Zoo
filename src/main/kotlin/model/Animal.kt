package scZoo.model

import java.lang.StringBuilder

interface IAnimalSet : Iterable<Animal> {
    operator fun get(index: Int): Animal
    fun toArray(): Array<Animal>
    fun isEmpty(): Boolean
}

abstract class AnimalsSet : HashSet<Animal>(), IAnimalSet {
    override operator fun get(index: Int): Animal =
        (super.toArray()[index] as Animal)
    override fun toArray(): Array<Animal> =
        super.toArray<Animal>(emptyArray())
}

private class AnimalFriends : AnimalsSet() {
    override fun toString(): String {
        val result : StringBuilder
        when (val friendCount = this.count()) {
            0 ->    return "[No friends]"
            1 ->    result =  StringBuilder("1 Friend only: ")
            else -> result =  StringBuilder("$friendCount Friends: ")
        }
        for (animal in this) {
            result.append(animal.name)
            result.append(", ")
        }
        result.delete(result.lastIndex, result.lastIndex)
        return result.toString()
    }
}

abstract class Animal(
    val name: String,
    var favoritePhrase: String
) {
    private val _friends = AnimalFriends()
    val friends: IAnimalSet
        get() = _friends

    override fun hashCode(): Int =
        this.name.toLowerCase().hashCode()

    override fun equals(other: Any?): Boolean =
        (this === other) || (this.hashCode() == other?.hashCode())

    protected open fun getClassDescription() = this.javaClass.simpleName

    override fun toString(): String =
        "${this.name} is a ${this.getClassDescription()}, its favorite phrase is \"${this.favoritePhrase}\""

    open fun isSocialWith(other: Animal): Boolean = true

    fun makeFriendship(friend: Animal): Boolean =
        (friend != this) && (this.isSocialWith(friend)) && (friend.isSocialWith(this)) && _friends.add(friend)

    fun breakFriendship(friend: Animal): Boolean =
        _friends.remove(friend)
}

