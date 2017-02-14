package se.jensim.domain

import java.io.Serializable
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class Product(
        @NotNull @Size(min = 2, max = 100) val name: String
) : Serializable