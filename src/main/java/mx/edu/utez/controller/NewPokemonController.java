package mx.edu.utez.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.model.dto.NewPokemonDto;
import mx.edu.utez.model.entity.NewPokemonBean;
import mx.edu.utez.service.impl.ImplNewPokemon;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/newpokemon")
public class NewPokemonController {
    private final ImplNewPokemon newPokemonService;

    @GetMapping("/")
    public List<NewPokemonBean> getNewpokemon() {
        return newPokemonService.findAll();
    }

    @GetMapping("/{id}")
    public NewPokemonBean showById(@PathVariable Integer id) {
        return newPokemonService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody NewPokemonDto newPokemonDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            NewPokemonBean newpokemonSave = newPokemonService.save(newPokemonDto);
            response.put("mensaje", "Pokemon creado correctamente");
            response.put("Pokemon", newpokemonSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Error al crear el pokemon");
            response.put("Pokemon", null);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody NewPokemonDto newPokemonDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            NewPokemonBean newpokemonUpdate = newPokemonService.save(newPokemonDto);
            response.put("mensaje", "Pokemon actualizado correctamente");
            response.put("Pokemon", newpokemonUpdate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar el pokemon");
            response.put("Pokemon", null);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            NewPokemonBean pokemon = newPokemonService.findById(id);
            newPokemonService.delete(pokemon);
            response.put("mensaje", "Pokemon eliminado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el pokemon");
            response.put("Pokemon", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
