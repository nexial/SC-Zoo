package scZoo.model

class Parrot(
    name: String,
    favoritePhrase: String,
    wingsLength: Double,
    val canSpeak: Boolean
) : Bird(name, favoritePhrase, wingsLength) {
    protected fun canSpeakText(): String = if(canSpeak) "it can speak" else "it cannot speak"
    override fun toString() = "${super.toString()}, ${this.canSpeakText()}"
}