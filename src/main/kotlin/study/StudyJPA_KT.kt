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
        val newMember : Member = Member("member")
        em.persist(newMember)
        val newTeam : Team = Team("team")
        newTeam.addMember(newMember)
        em.persist(newTeam)
        em.flush()
        em.clear()

        val findMember = em.find(Member::class.java, newMember.id)
        //코틀린에서 지연로딩 확인을 어떻게 해야하지...
        println("findMember = ${findMember.team!!.javaClass.classes}")

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}