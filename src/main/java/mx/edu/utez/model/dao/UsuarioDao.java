package mx.edu.utez.model.dao;

import mx.edu.utez.model.entity.UsuarioBean;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<UsuarioBean, Integer> {
}
