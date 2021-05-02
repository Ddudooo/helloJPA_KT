package study.domain

import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class Order {
    @Id
    @GeneratedValue
    var id : Long? =null

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    var member : Member

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    var product : Product

    constructor(member: Member, product: Product) {
        this.member = member
        this.product = product
    }
}