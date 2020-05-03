package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.UserRole;
import kg.itacademy.laborexchange.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findAll();
    UserRole create(UserRole userRole);
    UserRole create(UserRoleModel userRoleModel);
}
