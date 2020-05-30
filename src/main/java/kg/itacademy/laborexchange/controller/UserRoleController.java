package kg.itacademy.laborexchange.controller;

import kg.itacademy.laborexchange.entity.UserRole;
import kg.itacademy.laborexchange.model.UserRoleModel;
import kg.itacademy.laborexchange.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAll(){
        return userRoleService.findAll();
    }

    @PostMapping
    public UserRole create(@RequestBody UserRoleModel userRoleModel){
        return userRoleService.create(userRoleModel);
    }

    @PostMapping("/old")
    public UserRole create(@RequestBody UserRole userRole){
        return userRoleService.create(userRole);
    }
}
