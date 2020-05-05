package kg.itacademy.laborexchange.controller;


import kg.itacademy.laborexchange.entity.Test;
import kg.itacademy.laborexchange.model.TestModel;
import kg.itacademy.laborexchange.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/old")
    public Test create(@RequestBody Test test){
        return testService.create(test);
    }

    @PostMapping
    public Test create(@RequestBody TestModel testModel, Principal principal){
        return testService.create(testModel, principal.getName());
    }

    @GetMapping("/my")
    public List<Test> getTestByToken(Principal principal){
        return testService.getAllByUserLogin(principal.getName());
    }
}
