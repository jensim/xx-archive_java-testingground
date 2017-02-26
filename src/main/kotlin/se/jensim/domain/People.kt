package se.jensim.domain

class People(people: Set<Person>) : Set<Person> by people{
    constructor() : this(emptySet())
    constructor(people: List<Person>) : this(people.toSet())
}