package kg.itacademy.laborexchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkRequests extends EntityBase{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "services_id", nullable = false)
    private Services services;
    @Column(name = "status", nullable = false)
    private Integer status;
}
