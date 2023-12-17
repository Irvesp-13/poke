package mx.edu.utez.service;

import mx.edu.utez.model.dto.UsuarioDto;
import mx.edu.utez.model.entity.UsuarioBean;

import java.util.List;

public interface IUsuario {
    UsuarioBean save(UsuarioDto usuarios);

    UsuarioBean findById(Integer id);

    List<UsuarioBean> findAll();

    void delete(UsuarioBean usuarios);
}
