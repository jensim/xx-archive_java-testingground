package se.jensim.service

import org.springframework.stereotype.Service


@Service
class MyService {

    fun sayHi(): String {
        return "Hello Spring Initializr!"
    }
}