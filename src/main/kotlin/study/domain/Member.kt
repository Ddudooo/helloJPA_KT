package study.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Member{
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    var team : Team? = null
//    var teamId : Long? = null

    constructor(name : String) {
        this.name = name
    }

    constructor(name : String, team : Team){
        this.name = name
        this.team = team
    }
}