package greg.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import greg.com.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
