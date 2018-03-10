package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.Location;
import artyfartyparty.solowebservice.Model.Ride;
import artyfartyparty.solowebservice.Repository.LocationRepository;
import artyfartyparty.solowebservice.Repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {

    private LocationRepository locationRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> findAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    @RequestMapping(value="/addAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> addAllLocations() {
        Location a = new Location();
        a.setName("Háskóli Íslands");
        locationRepository.save(a);

        a.setName("Árbær");
        locationRepository.save(a);


        a.setName("Hlíðar");
        locationRepository.save(a);


        a.setName("Kársnes");
        locationRepository.save(a);

        a.setName("Grafarvogur");
        locationRepository.save(a);

        a.setName("Vesturbær");
        locationRepository.save(a);
        List<Location> locations = locationRepository.findAll();
        return locations;
    }
}
