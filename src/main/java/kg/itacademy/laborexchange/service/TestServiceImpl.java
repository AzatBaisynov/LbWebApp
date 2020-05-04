package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.Test;
import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.model.TestModel;
import kg.itacademy.laborexchange.repository.TestRepository;
import kg.itacademy.laborexchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private UserService userService;

    @Override
    public Test create(TestModel testModel, String userLogin) {
        User user = userService.getByLogin(userLogin);
        if(user == null) {
            return null;
        }
        Test test = new Test();
        test.setCount(testModel.getCount());
        test.setName(testModel.getName());
        test.setUser(user);
        return testRepository.save(test);
    }

    @Override
    public Test create(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAllByUserLogin(String login) {
        return testRepository.getAllByUser_Login(login);
    }
}
