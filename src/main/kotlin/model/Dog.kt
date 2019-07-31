package scZoo.model

enum class DogType {
    Hunting,
    Working,
    Sport,
    Lap
}

class Dog(
    name: String,
    favoritePhrase: String,
    isPregnant: Boolean,
    val type: DogType
) : Mammal(name, favoritePhrase, isPregnant) {
    override fun getClassDescription() = "${this.type} ${super.getClassDescription()}"
}
