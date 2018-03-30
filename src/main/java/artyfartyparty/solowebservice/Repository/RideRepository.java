package artyfartyparty.solowebservice.Repository;

import artyfartyparty.solowebservice.Model.Location;
import artyfartyparty.solowebservice.Model.Ride;
import artyfartyparty.solowebservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByLocationFromAndLocationToAndDeleted(Location locationFrom, Location locationTo, boolean deleted);

    List<Ride> findByUserAndDeleted(User user, boolean deleted);

    List<Ride> findByDeleted(boolean deleted);
}
