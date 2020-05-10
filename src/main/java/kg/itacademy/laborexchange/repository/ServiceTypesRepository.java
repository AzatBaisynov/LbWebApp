package kg.itacademy.laborexchange.repository;

import kg.itacademy.laborexchange.entity.ServiceTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypesRepository extends JpaRepository<ServiceTypes, Long> {
}
