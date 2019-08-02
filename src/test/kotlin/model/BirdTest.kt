package model

import org.junit.jupiter.api.Test

internal class BirdTest {
    @Test
    fun testBirdWingsLengthLesserThanZeroBecomeZero() {
        val bird = NoAbstractBird("Polly", "", -3.3)
        assert(bird.wingsLength == 0.0) { "Bird wings lengths lesser than zero should become zero automatically but it is not happening." }
    }
}