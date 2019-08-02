package model

import org.junit.jupiter.api.Test
import scZoo.model.Snake

internal class SnakeTest {
    @Test
    fun testOtherAnimalCannotMakefriendshipWithSnake() {
        val animal = NoAbstractAnimal("Carlos", "")
        val snake = Snake("His name", "")
        assert(!animal.makeFriendship(snake)) { "An no snake animal should NOT become friend of a snake." }
    }
    @Test
    fun testSnakeCannotMakefriendshipWithOtherAnimal() {
        val snake = Snake("His name", "")
        val animal = NoAbstractAnimal("Carlos", "")
        assert(!snake.makeFriendship(animal)) { "A snake should NOT be able to become friend of another kind of animal." }
    }
    @Test
    fun testSnakeCanMakefriendshipWithOtherSnake() {
        val snake1 = Snake("Snake 1", "")
        val snake2 = Snake("Snake 2", "")
        assert(snake1.makeFriendship(snake2)) { "Although very disgusting, a snake may be able to make friendship at least with another snake." }
    }
}