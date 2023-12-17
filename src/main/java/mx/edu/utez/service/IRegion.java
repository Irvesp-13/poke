package mx.edu.utez.service;

import mx.edu.utez.model.dto.RegionDto;
import mx.edu.utez.model.entity.RegionBean;

import java.util.List;

public interface IRegion {
    RegionBean save(RegionDto regions);

    RegionBean findById(Integer id);

    List<RegionBean> findAll();

    void delete(RegionBean regions);
}
