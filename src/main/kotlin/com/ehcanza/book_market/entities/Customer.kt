package com.ehcanza.book_market.entities

import com.ehcanza.book_market.enums.CustomerStatus
import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String,

    @Column(unique = true)
    var email: String,

    @Enumerated(EnumType.STRING)
    var status: CustomerStatus

)