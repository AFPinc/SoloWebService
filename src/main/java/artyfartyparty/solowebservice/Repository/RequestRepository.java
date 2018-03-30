package artyfartyparty.solowebservice.Repository;

import artyfartyparty.solowebservice.Model.Request;
import artyfartyparty.solowebservice.Model.Ride;
import artyfartyparty.solowebservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByRideAndAcceptedAndRejectedAndDeleted(Ride ride, boolean accepted, boolean rejected, boolean delted);

    List<Request> findByUserAndDeleted(User user, boolean deleted);


}
