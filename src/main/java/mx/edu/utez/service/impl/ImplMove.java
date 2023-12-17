package mx.edu.utez.service.impl;

import mx.edu.utez.model.dao.MoveDao;
import mx.edu.utez.model.dto.MoveDto;
import mx.edu.utez.model.entity.MoveBean;
import mx.edu.utez.service.IMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplMove implements IMove {
    @Autowired
    private MoveDao moveDao;

    @Override
    @Transactional
    public MoveBean save(MoveDto moveDto) {
        MoveBean move = MoveBean.builder()
                .idMove(moveDto.getIdMove())
                .nombre(moveDto.getNombre())
                .tipo(moveDto.getTipo())
                .poder(moveDto.getPoder())
                .build();
        return moveDao.save(move);
    }

    @Override
    @Transactional(readOnly = true)
    public MoveBean findById(Integer id) {
        return moveDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MoveBean> findAll() {
        return (List<MoveBean>) moveDao.findAll();
    }

    @Override
    @Transactional
    public void delete(MoveBean move) {
        moveDao.delete(move);
    }
}
