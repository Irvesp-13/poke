package mx.edu.utez.service;

import mx.edu.utez.model.dto.NewPokemonDto;
import mx.edu.utez.model.entity.NewPokemonBean;

import java.util.List;

public interface INewPokemon {
    NewPokemonBean save(NewPokemonDto pokemos);

    NewPokemonBean findById(Integer id);

    List<NewPokemonBean> findAll();

    void delete(NewPokemonBean pokemons);
}
