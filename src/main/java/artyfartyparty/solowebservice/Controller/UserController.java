package artyfartyparty.solowebservice.Controller;

import artyfartyparty.solowebservice.Model.Request.AddUserRequest;
import artyfartyparty.solowebservice.Model.User;
import artyfartyparty.solowebservice.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void AddUser(@RequestBody AddUserRequest addUserRequest) {
        User user = new User();
        user.setName(addUserRequest.getName());
        userRepository.save(user);
    }
}
