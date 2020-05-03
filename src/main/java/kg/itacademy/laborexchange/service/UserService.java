package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Long id);
    List<User> getAll();
}
