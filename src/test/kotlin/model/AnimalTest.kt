package model

import org.junit.jupiter.api.Test

internal class AnimalTest {
    @Test
    fun testComparisonEquals() {
        val animal1 = NoAbstractAnimal("Carlos", "")
        val animal2 = NoAbstractAnimal("caRloS", "")
        assert(animal1 == animal2) {"Animal \"${animal1.name}}\" NOT considered equal to animal \"${animal1.name}}\", but it should."}
    }
    @Test
    fun testComparisonNotEquals() {
        val animal1 = NoAbstractAnimal("Carlos", "")
        val animal2 = NoAbstractAnimal("Marcos", "")
        assert(animal1 != animal2) {"Animal \"${animal1.name}}\" considered equal to animal \"${animal1.name}}\", but it should NOT."}
    }
    @Test
    fun testMakeFriendshipWithItselfFalse() {
        val animal1 = NoAbstractAnimal("Carlos", "")
        assert(!animal1.makeFriendship(animal1)) {"An animal cannot make friendship with itself."}
        assert(animal1.friends.isEmpty()) {"Somehow animal friends list modified anyway adding itself as friend."}
    }
    @Test
    fun testMakeFriendshipWithOtherTrue() {
        val animal1 = NoAbstractAnimal("Carlos", "")
        val animal2 = NoAbstractAnimal("Marcos", "")
        assert(animal1.makeFriendship(animal2)) {"Making friendship between \"${animal1.name}}\" failed \"${animal1.name}}\", but it should NOT."}
        assert(animal1.friends.count() == 1) {"Somehow animal friends list didn't get updated on adding a new friend."}
    }
    @Test
    fun testBreakFriendshipFailsWhenNoFriends() {
        val animal1 = NoAbstractAnimal("Carlos", "")
        assert(!animal1.breakFriendship(animal1)) {"Break friendship should fail when no previous friends were added."}
    }
    @Test
    fun testBreakFriendshipFailsWhenNoPreviouslyFriends() {
        val animal1 = NoAbstractAnimal("Carlos", "")
        val animal2 = NoAbstractAnimal("Marcos", "")
        val animal3 = NoAbstractAnimal("Santos", "")
        animal1.makeFriendship(animal2)
        assert(!animal1.breakFriendship(animal3)) {"Break friendship should fail when there was no previous friendship between the 2 animals."}
        assert(animal1.friends.count() == 1) {"Somehow animal friends list got changed on breaking a friendship with a no previously friend."}
    }
    @Test
    fun testBreakFriendshipSuccessAnimalsTheyWereFrieds() {
        val animal1 = NoAbstractAnimal("Carlos", "")
        val animal2 = NoAbstractAnimal("Marcos", "")
        animal1.makeFriendship(animal2)
        assert(animal1.breakFriendship(animal2)) {"Break friendship didn't workout with 2 animals previously made friends when it should."}
        assert(animal1.friends.count() == 0) {"Somehow animal friends list didn't get updated on removing the friendship."}
    }
}