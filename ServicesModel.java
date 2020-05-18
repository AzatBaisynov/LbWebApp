package kg.itacademy.laborexchange.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesModel {
    private String name;
    private String description;
    private Integer price;
    private LocalDate term;
    private Long userId;
    private List serviceTypesId;

}
