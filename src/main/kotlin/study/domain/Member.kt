package study.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@SequenceGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    sequenceName = "MEMBER_SEQ", //매핑할 시퀀스 명
    initialValue = 1, allocationSize = 1
)
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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