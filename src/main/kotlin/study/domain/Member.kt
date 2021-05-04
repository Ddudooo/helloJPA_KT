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

    @Embedded
    var workPeriod : Period

    @Embedded
    var homeAdress : Address
//    var teamId : Long? = null

    /*
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    var locker : Locker? = null
    */

    constructor(name: String, workPeriod: Period, homeAdress: Address) {
        this.name = name
        this.workPeriod = workPeriod
        this.homeAdress = homeAdress
    }

    constructor(name: String, team: Team, workPeriod: Period, homeAdress: Address){
        this.name = name
        this.team = team
        this.workPeriod = workPeriod
        this.homeAdress = homeAdress
    }

    /*
    연관관계 편의 메소드
    fun changeTeam(team : Team){
        this.team = team
        team.addMember(this)
    }
    */
}