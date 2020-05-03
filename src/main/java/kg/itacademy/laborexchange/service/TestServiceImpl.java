package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.Test;
import kg.itacademy.laborexchange.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;

    @Override
    public Test create(Test test) {
        return testRepository.save(test);
    }
}
