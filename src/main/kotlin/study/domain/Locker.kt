/*
package study.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Locker {
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    @OneToOne(mappedBy = "locker")
    var member : Member? = null

    constructor(name : String){
        this.name = name
    }
}*/
