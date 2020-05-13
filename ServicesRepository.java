package kg.itacademy.laborexchange.repository;

import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services,Long> {
    List<Services> findAllByName(Services name);
    List<Services> findAllByDateCreated(Services dateCreated);
    List<Services> findAllByServiceTypes(Services serviceTypes);
}
