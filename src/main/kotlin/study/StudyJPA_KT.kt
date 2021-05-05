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
        val resultList = em.createQuery(
            "select m From Member m where m.name like '%kim%'",
            Member::class.java
        ).resultList

        for(findMember:Member in resultList){
            println("member $findMember.name")
        }

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}