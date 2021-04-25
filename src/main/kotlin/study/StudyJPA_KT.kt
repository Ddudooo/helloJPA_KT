package study

import study.domain.Member
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
        val member :Member = Member(1L, "홍길동")
        /*val member : Member = em.find(Member::class.java, 1L);
        member.name = "수정"*/
        //수정시 persist 필요없음.

        //쿼리 작성
        /*
        val resultList = em.createQuery(
            "select m from Member as m",
            Member::class.java)
            .setFirstResult(1)
            .setMaxResults(100)
            .resultList
        */
        em.persist(member)
        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}