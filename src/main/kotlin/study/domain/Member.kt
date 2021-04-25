package study.domain

import javax.persistence.*

@Entity
data class Member(
    @Id
    val id : Long,

    @Column
    var name : String
)