package kg.itacademy.laborexchange.controller;

import kg.itacademy.laborexchange.entity.Test;
import kg.itacademy.laborexchange.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping
    public Test create(@RequestBody Test test){
        return testService.create(test);
    }
}
