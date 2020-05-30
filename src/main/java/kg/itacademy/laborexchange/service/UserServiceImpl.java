package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.entity.UserRole;
import kg.itacademy.laborexchange.model.UserAuth;
import kg.itacademy.laborexchange.model.UserClientModel;
import kg.itacademy.laborexchange.model.UserWorkerModel;
import kg.itacademy.laborexchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User create(UserWorkerModel userModel) {
        User user = new User();
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        user.setPassword(encodedPassword);
        user.setStatus(1);
        user.setCv(userModel.getCv());
        user.setLogin(userModel.getLogin());
        user =  userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleService.create(userRole);

        return user;
    }

    @Override
    public User create(UserClientModel userModel) {
        User user = new User();
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        user.setPassword(encodedPassword);
        user.setStatus(1);
        user.setLogin(userModel.getLogin());
        user =  userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_CLIENT");
        userRole.setUser(user);
        userRoleService.create(userRole);
        return user;
    }

    @Override
    public User createAdmin(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User user1 =  userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_ADMIN");
        userRole.setUser(user1);
        userRoleService.create(userRole);
        return user1;
    }


    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String getToken(UserAuth userAuth) {
        User user = getByLogin(userAuth.getLogin());
        if(user == null) return "Error";
        String rawPassword = userAuth.getPassword();
        String encodedPassword = user.getPassword();
        if (passwordEncoder.matches(rawPassword, encodedPassword)){
            String loginPasswordPair = user.getLogin() + ":" + userAuth.getPassword();
            String token = Base64.getEncoder().encodeToString(loginPasswordPair.getBytes());
            return "Basic " + token;
        }
        return "Error";
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }
}
