package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.model.UserAuth;
import kg.itacademy.laborexchange.model.UserClientModel;
import kg.itacademy.laborexchange.model.UserWorkerModel;
import java.util.List;

public interface UserService {
    User create(UserWorkerModel user);
    User create(UserClientModel user);
    User createAdmin(User user);
    User getById(Long id);
    List<User> getAll();
    String getToken(UserAuth userAuth);
    User getByLogin(String login);
}
