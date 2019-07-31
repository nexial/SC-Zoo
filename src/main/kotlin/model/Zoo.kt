package scZoo.model

git statusprivate class ZooAnimals : AnimalsSet() {
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
}