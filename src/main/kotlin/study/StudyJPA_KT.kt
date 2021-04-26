package study

import study.domain.Member
import study.domain.RoleType
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
        //비영속
        val member :Member = Member(1L, "홍길동",20, RoleType.USER, LocalDateTime.now(), LocalDateTime.now(), "test", 1)
        em.persist(member)
        println("member id = ${member.id}")
        println("==========================")
        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}