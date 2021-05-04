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
    var workPeriod : Period? = null

    @Embedded
    var homeAddress : Address

    /*@Embedded
    @AttributeOverrides(
        AttributeOverride(name="city", column = Column(name="work_city")),
        AttributeOverride(name = "street", column = Column(name="work_street")),
        AttributeOverride(name = "zipcode", column = Column(name="work_zipcode"))
    )
    var workAddress : Address*/
//    var teamId : Long? = null

    /*
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    var locker : Locker? = null
    */

    constructor(name: String, homeAddress: Address) {
        this.name = name
        this.homeAddress = homeAddress
    }

    constructor(name: String, team: Team, homeAddress: Address){
        this.name = name
        this.team = team
        this.homeAddress = homeAddress
    }

    /*
    연관관계 편의 메소드
    fun changeTeam(team : Team){
        this.team = team
        team.addMember(this)
    }
    */
}