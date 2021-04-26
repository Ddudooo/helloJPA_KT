package study.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Member(
    @Id
    val id: Long,

    @Column(name = "name")
    var username: String,

    var age: Int,

    @Enumerated(EnumType.STRING)
    var roleType: RoleType,

   /* @Temporal(TemporalType.TIMESTAMP)
    var createDate: Date,

    @Temporal(TemporalType.TIMESTAMP)
    var lastModifiedDate: Date,*/

    var createDate : LocalDateTime,

    var lastModifiedDate : LocalDateTime,

    @Lob
    var description: String,

    @Transient
    var temp : Int

    )