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

        val memberTeam : Team = member.team!!
        println("MEMBER[${member.name}] - TEAM[${memberTeam.name}]")

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}