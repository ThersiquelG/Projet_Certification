package greg.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import greg.com.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{

}
