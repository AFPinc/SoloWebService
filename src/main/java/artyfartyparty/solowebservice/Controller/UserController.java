package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.User;
import artyfartyparty.solowebservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<User> AddUser(@RequestBody User u) {
        User user = new User();
        user.setName(u.getName());
        user.setAddress(u.getAddress());
        user.setUniMail(u.getUniMail());
        user.setPhoneNumber(u.getPhoneNumber());
        user.setPassword(u.getPassword());
        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/{uniMail}", method=RequestMethod.GET)
    @ResponseBody
    public User getByUserName(@PathVariable(value = "uniMail") String uniMail) {
        return userRepository.findByUniMail(uniMail);
    }
}
