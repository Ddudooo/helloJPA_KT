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
        val newTeam :Team = Team("newTeam")
        em.persist(newTeam)

        for(i in 1..10) {
            val homeAddress: Address = Address("city", "street", "zipcode")
            val newMember: Member = Member("member$i", homeAddress)
            newMember.age = 10+i
            em.persist(newMember)
            newTeam.addMember(newMember)
        }

        em.flush()
        em.clear()

        val query = "select distinct t from Team t join fetch t.members "
        val resultList = em.createQuery(
            query, Team::class.java
        )
            .resultList

        println("result size = ${resultList.size}")
        for(find:Team in resultList){
            println("find value =  ${find.name}, ${find.members.size}")
            val members = find.members
            for(member :Member in members){
                println("team member = ${member.name}")
            }
        }

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}