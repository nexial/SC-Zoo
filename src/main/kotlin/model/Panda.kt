package scZoo.model

class Panda (
    name: String,
    favoritePhrase: String,
    isPregnant: Boolean,
    val extinctionRisk: Boolean
) : Mammal(name, favoritePhrase, isPregnant) {
    override fun toString(): String =
        if (extinctionRisk)
            "${super.toString()}, is gonna be extincted soon, such a pity"
        else
            super.toString()
}
