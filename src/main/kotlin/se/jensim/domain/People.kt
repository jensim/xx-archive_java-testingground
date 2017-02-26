package se.jensim.domain

import java.util.*

class People : Map<String, Person> by HashMap<String,Person>()