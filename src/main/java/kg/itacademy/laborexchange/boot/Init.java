package kg.itacademy.laborexchange.boot;

import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.entity.UserRole;
import kg.itacademy.laborexchange.service.TestService;
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
        User user = userService.createNoRole(new User("Admin","admin",1));
        userRoleService.create(new UserRole("ROLE_ADMIN", user));
//        taskService.create(new Task("First Task", "Create app", true));
//        taskService.create(new Task("Second Task", "Add Entity", false));
//        taskService.create(new Task("Important Task", "Call boss", false));
//        taskService.create(new Task("Test task", "qwerty", true));
//        taskService.create(new Task("Last Task", "Something", false));
    }
}
