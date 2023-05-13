package com.chatandpay.api.domain

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pay_member")
data class PayUser(

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(unique = true)
    val ci: String,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,
    val userSeqNo: String,
    @OneToOne(mappedBy = "payUser", cascade = [CascadeType.ALL])
    var wallet: Wallet? = null
)