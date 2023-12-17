package mx.edu.utez.controller;

import mx.edu.utez.model.dto.MoveDto;
import mx.edu.utez.model.entity.MoveBean;
import mx.edu.utez.service.IMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/move")
public class MoveController {
    @Autowired
    private IMove moveService;

    @GetMapping("/")
    public List<MoveBean> getMoves() {
        return moveService.findAll();
    }

    @GetMapping("/{id}")
    public MoveBean showById(@PathVariable Integer id) {
        return moveService.findById(id);
    }

    @PostMapping("/")
    public MoveDto create(@RequestBody MoveDto moveDto) {
        MoveBean moveSave = moveService.save(moveDto);
        return MoveDto.builder()
                .idMove(moveSave.getIdMove())
                .nombre(moveSave.getNombre())
                .tipo(moveSave.getTipo())
                .poder(moveSave.getPoder())
                .build();
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody MoveDto moveDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            MoveBean moveUpdate = moveService.save(moveDto);
            return new ResponseEntity<>(moveUpdate, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el movimiento");
            response.put("Move", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            MoveBean move = moveService.findById(id);
            moveService.delete(move);
            return new ResponseEntity<>(move, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el movimiento");
            response.put("Move", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
