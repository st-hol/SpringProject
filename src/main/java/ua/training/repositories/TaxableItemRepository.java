package ua.training.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.training.entities.TaxableItem;

public interface TaxableItemRepository extends CrudRepository<TaxableItem, Long> {
}
