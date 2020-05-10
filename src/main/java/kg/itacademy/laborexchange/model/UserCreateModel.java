package kg.itacademy.laborexchange.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateModel {
    private String login;
    private String password;
    private String cv;
}
