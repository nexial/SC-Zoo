package scZoo.model

class Snake(
    name: String,
    favoritePhrase: String
) : Animal(name, favoritePhrase) {
    override fun isSocialWith(other: Animal): Boolean = (other is Snake)
}
