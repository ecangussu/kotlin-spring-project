package com.ehcanza.book_market.entities

import com.ehcanza.book_market.enums.BookStatus
import com.ehcanza.book_market.enums.Errors
import com.ehcanza.book_market.exceptions.BadRequestException
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "book")
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String,

    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null

) {

    constructor(id: Long? = null,
                name: String,
                price: BigDecimal,
                customer: Customer? = null,
                status: BookStatus?): this(id, name, price, customer) {
                    this.status = status
                }

    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if(field == BookStatus.CANCELADO || field == BookStatus.DELETADO)
                throw BadRequestException(Errors.BM1002.message.format(field), Errors.BM1002.code)
            field = value
        }

}