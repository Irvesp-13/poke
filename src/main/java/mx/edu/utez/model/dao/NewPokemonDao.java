package mx.edu.utez.model.dao;

import mx.edu.utez.model.entity.NewPokemonBean;
import org.springframework.data.repository.CrudRepository;

public interface NewPokemonDao extends CrudRepository<NewPokemonBean, Integer> {
}