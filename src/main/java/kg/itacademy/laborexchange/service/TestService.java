package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.Test;
import kg.itacademy.laborexchange.model.TestModel;

import java.util.List;

public interface TestService {
    Test create(TestModel testModel, String userLogin);
    Test create(Test test);
    List<Test> getAllByUserLogin(String login);
}
