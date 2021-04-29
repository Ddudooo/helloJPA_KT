package study

import study.domain.Member
import study.domain.RoleType
import study.domain.Team
import java.time.LocalDateTime
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main(){
    val emf : EntityManagerFactory = Persistence.createEntityManagerFactory("study")
    val em : EntityManager = emf.createEntityManager()
    println("Hello JPA Kotlin!")
    val tx = em.transaction
    tx.begin()
    try {
        val team = Team("team")
        em.persist(team)

        val member = Member("name")
        member.team = team
        em.persist(member)

        team.addMember(member)

        em.flush()
        em.clear()

        val findTeam = em.find(Team::class.java, team.id)
        val members = findTeam.members
        for(findMember in members){
            println("FIND MEMBER ${findMember.id} ${findMember.name}")
        }

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}