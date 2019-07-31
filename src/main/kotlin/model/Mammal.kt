package scZoo.model

abstract class Mammal (
    name: String,
    favoritePhrase: String,
    var isPregnant: Boolean
) : Animal(name, favoritePhrase) {
    override fun toString(): String =
        if (isPregnant)
            "${super.toString()}, beware is pregnant!!!"
        else
            super.toString()
}