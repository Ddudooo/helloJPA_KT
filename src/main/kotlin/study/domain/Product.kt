package study.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Product {
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    @OneToMany(mappedBy = "product")
    var orders : MutableList<Order> = mutableListOf()

    constructor(name: String) {
        this.name = name
    }
}
