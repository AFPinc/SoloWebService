package artyfartyparty.solowebservice.Repository;

import artyfartyparty.solowebservice.Model.Location;
import artyfartyparty.solowebservice.Model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByLocationFromAndLocationTo(Location locationFrom, Location locationTo);
}
