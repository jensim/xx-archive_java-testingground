package se.jensim.domain

import java.io.Serializable
import javax.validation.constraints.NotNull

data class Order(
        @NotNull val customer: Person,
        @NotNull val orderItem: Product
) : Serializable