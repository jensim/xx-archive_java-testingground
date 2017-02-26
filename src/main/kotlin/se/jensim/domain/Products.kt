package se.jensim.domain

class Products(products: Set<Product>) : Set<Product> by products {
    constructor() : this(emptySet())
    constructor(products: List<Product>) : this(products.toSet())
}