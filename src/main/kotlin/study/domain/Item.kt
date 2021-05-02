package study.domain

import javax.persistence.*

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DIS_TYPE", discriminatorType = DiscriminatorType.STRING)
open class Item {
    @Id
    @GeneratedValue
    var id : Long? = null
    var name : String
    var price : Int

    constructor(name: String, price: Int) {
        this.name = name
        this.price = price
    }
}