package mvc.jdbc.service.a.mvcservicea.controller;

import mvc.jdbc.service.a.mvcservicea.model.User;
import mvc.jdbc.service.a.mvcservicea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.selectAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getOne(@PathVariable UUID id) {
        return userService.selectOneUser(id);
    }

    @PostMapping
    public User create(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable UUID id, @RequestBody @Valid User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }
}
