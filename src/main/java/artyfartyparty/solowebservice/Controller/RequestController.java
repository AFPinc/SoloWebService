package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.Request;
import artyfartyparty.solowebservice.Model.Ride;
import artyfartyparty.solowebservice.Model.User;
import artyfartyparty.solowebservice.Repository.RequestRepository;
import artyfartyparty.solowebservice.Repository.RideRepository;
import artyfartyparty.solowebservice.Repository.UserRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {

    private RequestRepository requestRepository;
    private UserRepository userRepository;
    private RideRepository rideRepository;

    @Autowired
    public RequestController(RequestRepository requestRepository, UserRepository userRepository, RideRepository rideRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.rideRepository = rideRepository;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Request> AddRequest(@RequestBody Request request) {

        if (request == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        requestRepository.save(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> AllRequests() {

        return requestRepository.findAll();
    }

    @RequestMapping(value="/byUser/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> RequestsByUser(@PathVariable(value = "userId") Long userId) {
        User user = userRepository.findOne(userId);
        return requestRepository.findByUser(user);
    }

    @RequestMapping(value="/byRide/{rideId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> RequestsByRide(@PathVariable(value = "rideId") Long rideId) {
        Ride ride = rideRepository.findOne(rideId);
        return requestRepository.findByRide(ride);
    }

    @RequestMapping(value="/accept", method = RequestMethod.PUT)
    public ResponseEntity<Request> AcceptRequest(@RequestBody Request request) {
        request.setAccepted(true);
        requestRepository.save(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @RequestMapping(value="/reject", method = RequestMethod.PUT)
    public ResponseEntity<Request> RejectRequest(@RequestBody Request request) {
        request.setRejected(true);
        requestRepository.save(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}
