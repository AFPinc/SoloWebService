package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.Location;
import artyfartyparty.solowebservice.Model.Ride;
import artyfartyparty.solowebservice.Repository.LocationRepository;
import artyfartyparty.solowebservice.Repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ride")
public class RideController {

    private RideRepository rideRepository;
    private LocationRepository locationRepository;

    @Autowired
    public RideController(RideRepository rideRepository, LocationRepository locationRepository) {
        this.rideRepository = rideRepository;
        this.locationRepository = locationRepository;
    }


    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Ride> findAllRides() {
        List<Ride> rides = rideRepository.findAll();
        return rides;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ride findOne(@PathVariable(value = "id") Long id) {
        Ride ride = rideRepository.findOne(id);
        return ride;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Ride> AddRide(@RequestBody Ride ride) {

        if (ride == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        rideRepository.save(ride);
        return new ResponseEntity<>(ride, HttpStatus.OK);
    }

    @RequestMapping(value="/search/{locationFromID}/{locationToID}", method = RequestMethod.GET)
    @ResponseBody
    public List<Ride> find(@PathVariable(value = "locationFromID") Long locationFromId,
                           @PathVariable(value = "locationToID") Long locationToId) {
        Location locationFrom = locationRepository.getOne(locationFromId);
        Location locationTo = locationRepository.getOne(locationToId);
        List<Ride> rides = rideRepository.findByLocationFromAndLocationTo(locationFrom, locationTo);
        return rides;
    }
}
