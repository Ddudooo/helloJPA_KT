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
        //영속
        println("=== BEFORE ===")
        //1차 캐시에 저장.
        em.persist(member)
        println("=== AFTER ===")

        //1차 캐시에서 조회
        val findMember = em.find(Member::class.java, 1L)
        println(findMember)

        //커밋 시점에 db 쿼리 실행
        //트랜잭션 커밋 시점에서 DB 요청을 보내기때문에 일종의 쓰기 지연식으로 사용가능하다.
        tx.commit()
    } catch (e: Exception){
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}