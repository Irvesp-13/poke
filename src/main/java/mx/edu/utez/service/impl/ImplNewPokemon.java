package mx.edu.utez.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.model.dao.MoveDao;
import mx.edu.utez.model.dao.NewPokemonDao;
import mx.edu.utez.model.dao.RegionDao;
import mx.edu.utez.model.dao.UsuarioDao;
import mx.edu.utez.model.dto.NewPokemonDto;
import mx.edu.utez.model.entity.MoveBean;
import mx.edu.utez.model.entity.NewPokemonBean;
import mx.edu.utez.model.entity.RegionBean;
import mx.edu.utez.model.entity.UsuarioBean;
import mx.edu.utez.service.INewPokemon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImplNewPokemon implements INewPokemon {
    private final NewPokemonDao newPokemonDao;
    private final UsuarioDao usuarioDao;
    private final RegionDao regionDao;
    private final MoveDao moveDao;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public NewPokemonBean save(NewPokemonDto newPokemonDto) {
        UsuarioBean usuarioBean = usuarioDao.findById(newPokemonDto.getUsuario_idusuario()).orElse(null);
        RegionBean regionBean = regionDao.findById(newPokemonDto.getRegion_idregion()).orElse(null);
        NewPokemonBean pokemon = NewPokemonBean.builder()
                .idNewPokemon(newPokemonDto.getIdNewPokemon())
                .nombre(newPokemonDto.getNombre())
                .tipo(newPokemonDto.getTipo())
                .nivel(newPokemonDto.getNivel())
                .esLegendario(newPokemonDto.getEsLegendario())
                .usuarioBean(usuarioBean)
                .regionBean(regionBean)
                .build();
        Set<MoveBean> moves = new HashSet<>();
        Set<NewPokemonBean> pokemons = new HashSet<>();
        pokemons.add(pokemon);
        moveDao.findAllById(newPokemonDto.getMoves()).forEach(move -> {
            pokemons.addAll(move.getPokemon()) ;
            move.setPokemon(pokemons);
            moves.add(move);
        });
        pokemon.setMove(moves);
        return newPokemonDao.save(pokemon);
    }

    @Override
    public NewPokemonBean findById(Integer id) {
        return null;
    }

    @Override
    public List<NewPokemonBean> findAll() {
        return (List<NewPokemonBean>) newPokemonDao.findAll();
    }

    @Override
    public void delete(NewPokemonBean pokemon) { newPokemonDao.delete(pokemon); }
}
