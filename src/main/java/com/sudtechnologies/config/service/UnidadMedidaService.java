package com.sudtechnologies.config.service;

import com.sudtechnologies.config.entity.UnidadMedida;
import com.sudtechnologies.config.repo.MedidaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Usuario on 3/11/2017.
 */
@Service
public class UnidadMedidaService {

    @Autowired
    private MedidaRepo repo;

    public UnidadMedida inicializar(){
        UnidadMedida m = new UnidadMedida();
        m.setEstado(Boolean.TRUE);
        return m;
    }

    public List<UnidadMedida> obtenerActivos() {
        return repo.buscarTodos();
    }
}
