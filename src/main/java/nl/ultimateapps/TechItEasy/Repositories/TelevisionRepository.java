package nl.ultimateapps.TechItEasy.Repositories;

import nl.ultimateapps.TechItEasy.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository; // WAAROM DEZE NIET???

public interface TelevisionRepository extends JpaRepository<Television, Long> {


}
