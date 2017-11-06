package com.sudtechnologies.config.service;

import com.sudtechnologies.config.entity.District;
import com.sudtechnologies.config.error.exception.ResourceNotFoundException;
import com.sudtechnologies.config.repository.DistrictRepository;
import com.sudtechnologies.config.rest.dto.DistrictDto;
import com.sudtechnologies.config.util.UtilCore;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DistrictService {

    private static Logger logger = Logger.getLogger(DistrictService.class);

    @Autowired
    private DistrictRepository repository;


    /**
     * Inicializar Distrito
     *
     * @return
     */
    private District innit() {
        District d = new District();
        d.setState(Boolean.TRUE);
        d.setDateCreated(UtilCore.UtilFecha.fechaActual());
        return d;
    }

    /**
     * Listar distritos activos
     *
     * @return
     */
    public List<District> findAll() {
        return repository.findAll();
    }

    /**
     * Listar distritos por id
     *
     * @param id
     * @return
     */
    public District findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Agregar un item de distrito
     *
     * @param dto
     */
    @Transactional
    public District add(DistrictDto dto) {
        District d = innit();

        d.setUserCreated(dto.getUserCreated());
        d.setName(dto.getName());
        d = repository.save(d);
        return d;
    }

    public District saveOrUpdate(District district) {
        return repository.save(district);
    }

    public District update(Long id, DistrictDto dto) {

        District district = repository.findById(id);
        district.setName(dto.getName());
        District updatedDistrict = saveOrUpdate(district);

        return updatedDistrict;
    }



    /**
     * Elimina un item de distrito
     *
     * @param id
     */
    public void delete(Long id) {
        District district = repository.findById(id);
        if (district != null) {
            district.setState(Boolean.FALSE);
            saveOrUpdate(district);
        }
    }
}
