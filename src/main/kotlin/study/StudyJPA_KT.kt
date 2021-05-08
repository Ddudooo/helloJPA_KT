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

        val homeAddress: Address = Address("city", "street", "zipcode")
        val newMember: Member = Member("newTeam", homeAddress)
        newMember.age = 10
        em.persist(newMember)

        newTeam.addMember(newMember)

        em.flush()
        em.clear()

        val query = "select " +
                "case when m.age <= 10 then '학생' " +
                "when m.age >= 60 then '경로' " +
                "else '일반' end "+
                "from Member m "
        val resultList = em.createQuery(
            query, String::class.java
        )
            .resultList

        println("result size = ${resultList.size}")
        for(find:String in resultList){
            println("find value =  $find")
        }

        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}