package study.domain

import javax.persistence.*

@Entity
class Team {
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String

    /**
     * 컴파일 결과로는 List로 생성되나 선언시 사용용도에 따라 사용...
     *
     * @see <a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/">MutableList</a>
     */
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY )
    //var members : List<Member> = listOf()
    var members : MutableList<Member> = mutableListOf()

    constructor(name : String){
        this.name = name
    }

    /**
     * 양방향 연관관계 편의 메소드
     */
    fun addMember(member: Member){
        members.add(member)
        member.team = this
    }
}