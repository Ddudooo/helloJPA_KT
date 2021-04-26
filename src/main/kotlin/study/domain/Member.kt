package study.domain

import javax.persistence.*

@Entity
data class Member(
    @Id
    val id : Long,

    @Column(unique = true, length = 10) //DDL 생성 기능
    var name : String
)