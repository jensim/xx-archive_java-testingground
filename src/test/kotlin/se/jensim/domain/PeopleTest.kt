package se.jensim.domain

import org.junit.Assert.assertTrue
import org.junit.Test


class PeopleTest {

    @Test
    internal fun makeAMap() {
        var people = People()
        assertTrue(people.isEmpty())
    }
}
