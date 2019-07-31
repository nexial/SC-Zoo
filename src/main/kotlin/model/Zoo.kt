package scZoo.model

private class ZooAnimals : AnimalsSet() {
    override fun toString(): String {
        val result = StringBuilder()
        for (animal in this) {
            result.appendln(animal)
            result.appendln("   ${animal.friends}")
        }
        return result.toString()
    }
}

class Zoo {
    private val _animals = ZooAnimals()
    val animals: IAnimalSet
        get() = _animals
    init {
        _animals.add(
            Dog("Angel", "Mira esto!", false, DogType.Lap))
        _animals.add(
            Panda("Bruno", "Acabo de contestar a los e-mails y vengo...", false, true))
        _animals.add(
            Parrot("Edgardo", "Tiene un buen culo, es foshable, si patron!", 1.0, true))
        _animals.add(
            Monkey("Jandro", "Ah ahhhhhhhhh", false))
        _animals.add(
            Unicorn("Oscar", "Esto es un Cristo, Cup Size, Show me the money, no me toques los Kubernetes", false))
        _animals.add(
            Chicken("Polly", "Squeeze me... cheeeeeeeeeeek!", 0.0, ChickenType.Plastic))
        _animals.add(
            Lion("Samson", "... (Has headphones on)", true))
        _animals.add(
            Snake("???", "Earn less, work more hours and don't look happy, it's not a professional behave"))
    }
}

