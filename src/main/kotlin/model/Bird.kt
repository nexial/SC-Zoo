package scZoo.model

abstract class Bird(
    name: String,
    favoritePhrase: String,
    var wingsLength: Number
): Animal(name, favoritePhrase) {
    override fun toString() = "${super.toString()}, has a wings length of ${this.wingsLength}"
}