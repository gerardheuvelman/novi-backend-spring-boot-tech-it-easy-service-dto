package nl.ultimateapps.TechItEasy.Repositories;

import nl.ultimateapps.TechItEasy.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository; // WAAROM DEZE NIET???

import java.util.List;
import java.util.Optional;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    public Iterable<Television> findByBrandContaining(String brand);

}
