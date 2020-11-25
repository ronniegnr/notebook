package bd.com.ronnie.hisab.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "account_head")
open class AccountHead {

    @get:Id
    @get:GeneratedValue
    @get:Column(name = "id")
    open var id: Long? = null

    @get:Column(name = "name")
    open var name: String? = null

    open var status: AccountHead.Status = Status.ACTIVE

    enum class Status { ACTIVE, INACTIVE }

}