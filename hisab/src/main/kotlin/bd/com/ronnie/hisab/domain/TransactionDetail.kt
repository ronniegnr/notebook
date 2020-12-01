package bd.com.ronnie.hisab.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "transaction_detail")
class TransactionDetail() {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @get:JoinColumn(name = "transaction_id")
    @get:ManyToOne(cascade = arrayOf())
    var transaction: Transaction? = null

    @get:Column(name = "amount")
    var amount: Int? = null

    @get:Enumerated(EnumType.STRING)
    @get:Column(name = "type")
    var type: Type? = null

    enum class Type { SOURCE, DESTINATION }

}