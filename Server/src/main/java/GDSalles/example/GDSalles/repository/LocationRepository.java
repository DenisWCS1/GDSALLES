package GDSalles.example.GDSalles.repository;

import GDSalles.example.GDSalles.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
