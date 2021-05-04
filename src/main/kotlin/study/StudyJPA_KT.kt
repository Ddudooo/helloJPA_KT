package study

import study.domain.*
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
        val address: Address = Address("city","street", "100-000")

        val period : Period = Period(LocalDateTime.now(), LocalDateTime.now())

        val member1 : Member = Member("member1", address)

        em.persist(member1)

        val member2 : Member = Member("member2", address)

        em.persist(member2)

        member1.homeAddress.city = "newCity"

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}