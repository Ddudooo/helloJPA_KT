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
        val child1 = Child("child1")
        val child2 = Child("child2")

        val parent = Parent("parent")
        parent.addChild(child1)
        parent.addChild(child2)
        em.persist(parent)
        em.persist(child1)
        em.persist(child2)

        em.flush()
        em.clear()

        val findParent = em.find(Parent::class.java, parent.id)
        em.remove(findParent)

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}