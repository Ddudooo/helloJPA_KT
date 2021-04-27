package study.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Team {
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    constructor(name : String){
        this.name = name
    }
}