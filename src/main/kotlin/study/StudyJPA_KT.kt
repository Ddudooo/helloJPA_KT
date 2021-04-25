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
        //비영속
        val member :Member = Member(1L, "홍길동")
        em.persist(member)

        //쓰기 지연 과정에 가진 쿼리들을 DB에 요청
        //영속성 컨텍스트를 비우지 않음.
        //영속성 컨텍스트 와 데이베이스의 동기화!
        em.flush()

        println("==========================")
        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}