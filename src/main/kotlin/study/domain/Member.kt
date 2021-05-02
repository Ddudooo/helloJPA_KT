package study.domain

import javax.persistence.*

@Entity
class Member : BaseEntity{
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    var team : Team? = null
//    var teamId : Long? = null

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    var locker : Locker? = null

    constructor(name : String) {
        this.name = name
    }

    constructor(name : String, team : Team){
        this.name = name
        this.team = team
    }

    /*
    연관관계 편의 메소드
    fun changeTeam(team : Team){
        this.team = team
        team.addMember(this)
    }
    */
}