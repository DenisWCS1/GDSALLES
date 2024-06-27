package GDSalles.example.GDSalles.repository;

import GDSalles.example.GDSalles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
