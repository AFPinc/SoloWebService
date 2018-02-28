package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.Location;
import artyfartyparty.solowebservice.Model.Ride;
import artyfartyparty.solowebservice.Model.Stopover;
import artyfartyparty.solowebservice.Repository.LocationRepository;
import artyfartyparty.solowebservice.Repository.RideRepository;
import artyfartyparty.solowebservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/ride")
public class RideController {

    private RideRepository rideRepository;
    private LocationRepository locationRepository;
    private UserRepository userRepository;

    @Autowired
    public RideController(RideRepository rideRepository, LocationRepository locationRepository, UserRepository userRepository) {
        this.rideRepository = rideRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Ride> findAllUsers() {
        List<Ride> rides = rideRepository.findAll();
        return rides;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Ride> AddUser(@RequestBody Ride r) {
        Ride ride = new Ride();
        ride.setFrom(bla(r.getFrom().getName()));
        ride.setTo(bla(r.getTo().getName()));
        ride.setFromDate(r.getFromDate());
        ride.setToDate(r.getToDate());
        ride.setUser(userRepository.findByName(r.getUser().getName()));
        ride.setStopovers(new HashSet<Stopover>() {
        });

        rideRepository.save(ride);
        return new ResponseEntity<>(ride, HttpStatus.OK);
    }

    private Location bla(String name) {
        Location loc = locationRepository.findByName(name);
        if (loc == null) {
            Location location = new Location();
            location.setName(name);
            locationRepository.save(location);
            loc = locationRepository.findByName(name);
        }
        return loc;
    }


}
