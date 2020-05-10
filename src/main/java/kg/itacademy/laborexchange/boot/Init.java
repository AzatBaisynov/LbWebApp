package kg.itacademy.laborexchange.boot;

import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.service.UserRoleService;
import kg.itacademy.laborexchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** То что будет выполнено после запуска приложения
 *  В данном примере будут добавлены Task'и в базу данных **/

@Component
public class Init implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        user.setCv("main role");
        user.setStatus(1);
        userService.createAdmin(user);
    }
}
