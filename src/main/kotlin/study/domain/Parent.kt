package study.domain

import javax.persistence.*

@Entity
class Parent : BaseEntity {
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    var children : MutableList<Child> = mutableListOf()

    constructor(name: String){
        this.name = name
    }

    fun addChild(child : Child){
        this.children.add(child)
        child.parent = this
    }
}