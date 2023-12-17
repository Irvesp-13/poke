package mx.edu.utez.model.dao;

import mx.edu.utez.model.entity.MoveBean;
import org.springframework.data.repository.CrudRepository;

public interface MoveDao extends CrudRepository<MoveBean, Integer> {
}
