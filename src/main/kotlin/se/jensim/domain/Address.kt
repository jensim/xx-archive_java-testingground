package se.jensim.domain

import java.io.Serializable

data class Address(
        var streetAddress: String = "",
        var city: String = "",
        var postalCode: String = "",
        var country: String = "")
    : Serializable