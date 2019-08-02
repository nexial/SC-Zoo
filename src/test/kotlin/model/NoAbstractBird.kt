package model

import scZoo.model.Bird

// Required because Bird class is abstract
internal class NoAbstractBird(
    name: String,
    favoritePhrase: String,
    wingsLength: Double
) : Bird(name, favoritePhrase, wingsLength)
