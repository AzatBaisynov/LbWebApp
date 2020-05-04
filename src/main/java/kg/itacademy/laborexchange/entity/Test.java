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
@AllArgsConstructor
@NoArgsConstructor
public class Test extends EntityBase{
    @Column(name = "test_name")
    private String name;
    @Column(name = "count")
    private Integer count;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
