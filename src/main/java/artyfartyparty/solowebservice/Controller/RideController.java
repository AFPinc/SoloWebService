package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.Ride;
import artyfartyparty.solowebservice.Model.User;
import artyfartyparty.solowebservice.Repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ride")
public class RideController {

    private RideRepository rideRepository;

    @Autowired
    public RideController(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
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
        ride.setFrom(r.getFrom());
        ride.setTo(r.getTo());
        ride.setFromDate(r.getFromDate());
        ride.setToDate(r.getToDate());
        ride.setUser(r.getUser());
        ride.setStopovers(r.getStopovers());

        rideRepository.save(ride);
        return new ResponseEntity<>(ride, HttpStatus.OK);
    }
}