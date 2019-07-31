package scZoo.model

enum class ChickenType {
    Broiler,
    Wild,
    Plastic
}

class Chicken (
    name: String,
    favoritePhrase: String,
    wingsLength: Double,
    val type: ChickenType
) : Bird(name, favoritePhrase, wingsLength) {
    override fun getClassDescription() = "${this.type} ${super.getClassDescription()}"
}