package bd.com.ronnie.hisab.domain

import java.time.LocalDateTime
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
class AccountHead() {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "id")
    var id: Long? = null

    @get:Column(name = "name")
    var name: String? = null

    @get:Enumerated(EnumType.STRING)
    @get:Column(name = "status")
    var status: Status = Status.ACTIVE

    @get:Column(name = "created")
    var created: LocalDateTime? = LocalDateTime.now()

    @get:Column(name = "updated")
    var updated: LocalDateTime? = null

    constructor(name: String?, status: Status) : this() {
        this.name = name
        this.status = status
    }

    enum class Status { ACTIVE, INACTIVE }

}