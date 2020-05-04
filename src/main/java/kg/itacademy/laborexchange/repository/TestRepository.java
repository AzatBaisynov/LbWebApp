package kg.itacademy.laborexchange.repository;

import kg.itacademy.laborexchange.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> getAllByUser_Login(String login);
}
