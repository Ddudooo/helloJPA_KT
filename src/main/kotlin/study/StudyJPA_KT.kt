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
        for(i in 1..100) {
            val homeAddress: Address = Address("city", "street", "zipcode")
            val newMember: Member = Member("name${i}", homeAddress)
            newMember.age = i
            em.persist(newMember)
        }

        em.flush()
        em.clear()

        val resultList = em.createQuery(
            "select m From Member m order by m.age desc",
            Member::class.java
        )
            .setFirstResult(1)
            .setMaxResults(10)
            .resultList

        println("result size = ${resultList.size}")
        for(findMember:Member in resultList){
            println("member ${findMember.name}")
        }

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}