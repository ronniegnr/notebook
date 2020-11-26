package bd.com.ronnie.hisab.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "account_head")
open class AccountHead() {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "id")
    open var id: Long? = null

    @get:Column(name = "name")
    open var name: String? = null

    @get:Enumerated(EnumType.STRING)
    @get:Column(name = "status")
    open var status: Status = Status.ACTIVE

    constructor(name: String?, status: Status) : this() {
        this.name = name
        this.status = status
    }


    enum class Status { ACTIVE, INACTIVE }

}