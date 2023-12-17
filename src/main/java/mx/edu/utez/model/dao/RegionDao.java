package mx.edu.utez.model.dao;

import mx.edu.utez.model.entity.RegionBean;
import org.springframework.data.repository.CrudRepository;

public interface RegionDao extends CrudRepository<RegionBean, Integer> {
}
