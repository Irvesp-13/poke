package mx.edu.utez.controller;

import mx.edu.utez.model.dto.RegionDto;
import mx.edu.utez.model.entity.RegionBean;
import mx.edu.utez.service.IRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/region")
public class RegionController {
    @Autowired
    private IRegion regionService;

    @GetMapping("/")
    public List<RegionBean> getRegion() {
        return regionService.findAll();
    }

    @GetMapping("/{id}")
    public RegionBean showById(@PathVariable Integer id) {
        return regionService.findById(id);
    }

    @PostMapping("/")
    public RegionDto create(@RequestBody RegionDto regionDto) {
        RegionBean regionSave = regionService.save(regionDto);
        return RegionDto.builder()
                .idRegion(regionSave.getIdRegion())
                .nombre(regionSave.getNombre())
                .build();
    }

    @PutMapping("/")
    public RegionDto update(@RequestBody RegionDto regionDto) {
        RegionBean regionUpdate = regionService.save(regionDto);
        return RegionDto.builder()
                .idRegion(regionUpdate.getIdRegion())
                .nombre(regionUpdate.getNombre())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        RegionBean branch = regionService.findById(id);
        regionService.delete(branch);
    }
}
