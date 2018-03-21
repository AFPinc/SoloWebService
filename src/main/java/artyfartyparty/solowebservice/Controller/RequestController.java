package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.Request;
import artyfartyparty.solowebservice.Repository.RequestRepository;
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
@RequestMapping("/request")
public class RequestController {

    private RequestRepository requestRepository;

    @Autowired
    public RequestController(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
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
}
