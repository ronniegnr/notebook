package bd.com.ronnie.hisab.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "transaction")
class Transaction() {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "id")
    var id: Int? = null

    @get:OneToOne(cascade = arrayOf())
    @get:JoinColumn(name = "destination_account_head_id")
    var destinationAccountHead: AccountHead? = null

    @get:OneToOne(cascade = arrayOf())
    @get:JoinColumn(name = "source_account_head_id")
    var sourceAccountHead: AccountHead? = null

    @get:Column(name = "purpose")
    var purpose: String? = null

    @get:Column(name = "amount")
    var amount: Int? = null

    @get:Enumerated(EnumType.STRING)
    @get:Column(name = "status")
    open var status: AccountHead.Status = AccountHead.Status.ACTIVE

    @get:Column(name = "created")
    var created: LocalDateTime? = LocalDateTime.now()

    @get:Column(name = "updated")
    var updated: LocalDateTime? = null

//    constructor()

    enum class Status { ACTIVE, INACTIVE }

}