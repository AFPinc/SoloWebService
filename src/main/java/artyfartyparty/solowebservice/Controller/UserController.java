package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.User;
import artyfartyparty.solowebservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void AddUser(@RequestBody User u) {
        User user = new User();
        user.setName(u.getName());
        userRepository.save(user);
    }
}
