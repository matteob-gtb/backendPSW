package reservations.journey_planner.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Train extends JpaRepository<Train, Integer> {
}
