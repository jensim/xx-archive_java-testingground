package se.jensim.domain

class Orders(orders: Set<Order>) : Set<Order> by orders {
    constructor() : this(emptySet())
    constructor(orders: List<Order>) : this(orders.toSet())
}