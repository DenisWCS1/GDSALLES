package GDSalles.example.GDSalles.repository;

import GDSalles.example.GDSalles.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
