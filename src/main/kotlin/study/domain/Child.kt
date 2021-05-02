package study.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Child : BaseEntity{

    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    @ManyToOne
    var parent: Parent? = null

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, parent: Parent) : super() {
        this.name = name
        this.parent = parent
    }
}