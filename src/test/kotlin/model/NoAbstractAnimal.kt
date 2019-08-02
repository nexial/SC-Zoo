package model

import scZoo.model.Animal

// Required because Animal class is abstract
internal class NoAbstractAnimal  (
    name: String,
    favoritePhrase: String
): Animal(name, favoritePhrase)
