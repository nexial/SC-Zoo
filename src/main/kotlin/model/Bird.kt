package scZoo.model

import java.lang.Double.max

abstract class Bird : Animal {
    constructor (
        name: String,
        favoritePhrase: String,
        wingsLength: Double
    ) : super(name, favoritePhrase) {
        this.wingsLength = wingsLength
    }
    private var _wingsLength: Double = 0.0
    var wingsLength: Double
        get() = this._wingsLength
        set(value) {
            _wingsLength = max(0.0, value)
        }
    override fun toString() = "${super.toString()}, has a wings length of ${this._wingsLength}"
}
