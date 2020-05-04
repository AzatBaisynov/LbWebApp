package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.model.UserAuth;

import java.util.List;

public interface UserService {
    User create(User user);
    User createNoRole(User user);
    User getById(Long id);
    List<User> getAll();
    String getToken(UserAuth userAuth);
    User getByLogin(String login);
}
