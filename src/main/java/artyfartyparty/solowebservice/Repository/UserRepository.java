package artyfartyparty.solowebservice.Repository;

import artyfartyparty.solowebservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUniMail(String uniMail);
}
