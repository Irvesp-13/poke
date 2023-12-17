package mx.edu.utez.service.impl;

import mx.edu.utez.model.dao.UsuarioDao;
import mx.edu.utez.model.dto.UsuarioDto;
import mx.edu.utez.model.entity.UsuarioBean;
import mx.edu.utez.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplUsuario implements IUsuario {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional
    public UsuarioBean save(UsuarioDto usuarioDto) {
        UsuarioBean usuario = UsuarioBean.builder()
                .idUsuario(usuarioDto.getIdUsuario())
                .nombre(usuarioDto.getNombre())
                .build();
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioBean findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioBean> findAll() {
        return (List<UsuarioBean>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void delete(UsuarioBean usuario) {
        usuarioDao.delete(usuario);
    }
}
