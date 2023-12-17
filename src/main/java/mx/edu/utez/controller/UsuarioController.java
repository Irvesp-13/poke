package mx.edu.utez.controller;

import mx.edu.utez.model.dto.UsuarioDto;
import mx.edu.utez.model.entity.UsuarioBean;
import mx.edu.utez.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    @Autowired
    private IUsuario usuarioService;

    @GetMapping("/")
    public List<UsuarioBean> getUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioBean showById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/")
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto) {
        UsuarioBean usuarioSave = usuarioService.save(usuarioDto);
        return UsuarioDto.builder()
                .idUsuario(usuarioSave.getIdUsuario())
                .nombre(usuarioSave.getNombre())
                .build();
    }
    @PutMapping("/")
    public UsuarioDto update(@RequestBody UsuarioDto usuarioDto) {
        UsuarioBean usuarioUpdate = usuarioService.save(usuarioDto);
        return UsuarioDto.builder()
                .idUsuario(usuarioUpdate.getIdUsuario())
                .nombre(usuarioUpdate.getNombre())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        UsuarioBean usuario = usuarioService.findById(id);
        usuarioService.delete(usuario);
    }
}
