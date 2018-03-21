package artyfartyparty.solowebservice.Repository;

import artyfartyparty.solowebservice.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
