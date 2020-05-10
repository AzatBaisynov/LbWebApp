package kg.itacademy.laborexchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends  EntityBase{
    @Column(name = "last_online")
    private LocalDate localDate;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "cv")
    private String cv;
    @ManyToMany
    @JoinColumn(name = "service_types_id")
    private List<ServiceTypes> serviceTypes;
    @Column(name = "status", nullable = false)
    private Integer status;

    @Override
    public String toString(){
        return this.login;
    }
}
