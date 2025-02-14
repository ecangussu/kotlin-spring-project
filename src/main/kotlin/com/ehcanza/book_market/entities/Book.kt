package com.ehcanza.book_market.entities

import com.ehcanza.book_market.enums.BookStatus
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
                throw Exception("Não é possível alterar o status de um livro ${BookStatus.CANCELADO} ou ${BookStatus.DELETADO}")
            field = value
        }

}