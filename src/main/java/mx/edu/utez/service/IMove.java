package mx.edu.utez.service;

import mx.edu.utez.model.dto.MoveDto;
import mx.edu.utez.model.entity.MoveBean;

import java.util.List;

public interface IMove {
    MoveBean save(MoveDto moves);

    MoveBean findById(Integer id);

    List<MoveBean> findAll();

    void delete(MoveBean moves);
}
