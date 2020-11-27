package bd.com.ronnie.hisab

import bd.com.ronnie.hisab.domain.AccountHead
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountHeadRepository: CrudRepository<AccountHead, Long>  {

}