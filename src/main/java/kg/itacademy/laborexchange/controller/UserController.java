package kg.itacademy.laborexchange.controller;

import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.model.UserAuth;
import kg.itacademy.laborexchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/test/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PostMapping("/auth")
    public ResponseEntity<String> getToken(@RequestBody UserAuth userAuth) {
        String result = userService.getToken(userAuth);
        if (result.equals("Error")) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/check")
    public User getByToken(Principal principal) {
        String login = principal.getName();
        return userService.getByLogin(login);
    }
}
