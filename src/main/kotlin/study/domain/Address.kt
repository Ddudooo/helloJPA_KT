package study.domain

import javax.persistence.Embeddable

@Embeddable
class Address(
    var city : String,
    var street : String,
    var zipcode : String
) {
    fun copy(
        city: String = this.city,
        street: String = this.street,
        zipcode: String = this.zipcode
    ): Address {
        return Address(city, street, zipcode)
    }
}