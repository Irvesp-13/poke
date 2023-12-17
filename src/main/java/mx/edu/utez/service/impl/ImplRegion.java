package mx.edu.utez.service.impl;

import mx.edu.utez.model.dao.RegionDao;
import mx.edu.utez.model.dto.RegionDto;
import mx.edu.utez.model.entity.RegionBean;
import mx.edu.utez.service.IRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplRegion implements IRegion {
    @Autowired
    private RegionDao regionDao;

    @Override
    @Transactional
    public RegionBean save(RegionDto regionDto) {
        RegionBean region = RegionBean.builder()
                .idRegion(regionDto.getIdRegion())
                .nombre(regionDto.getNombre())
                .build();
        return regionDao.save(region);
    }

    @Override
    @Transactional(readOnly = true)
    public RegionBean findById(Integer id) {
        return regionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegionBean> findAll() {
        return (List<RegionBean>) regionDao.findAll();
    }

    @Override
    @Transactional
    public void delete(RegionBean region) {
        regionDao.delete(region);
    }
}
