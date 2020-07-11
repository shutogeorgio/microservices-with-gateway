package mvc.jdbc.service.a.mvcservicea.service;

import mvc.jdbc.service.a.mvcservicea.model.Address;
import mvc.jdbc.service.a.mvcservicea.model.User;
import mvc.jdbc.service.a.mvcservicea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> selectOneUser(UUID id){
        return userRepository.findById(id);
    }

    public User createUser(User request){
        User newUser = new User();

        newUser.setId(UUID.randomUUID());
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setAddress(request.getAddress());

        return userRepository.saveAndFlush(newUser);
    }

    public User updateUser(UUID id, User request){
        User willUpdateUser = userRepository.findById(id).get();

        willUpdateUser.setFirstName(request.getFirstName());
        willUpdateUser.setLastName(request.getLastName());
        willUpdateUser.setEmail(request.getEmail());
        willUpdateUser.setAddress(request.getAddress());

        return userRepository.saveAndFlush(willUpdateUser);
    }

    public boolean deleteUser(UUID id){
        userRepository.deleteById(id);
        return true;
    }


}
