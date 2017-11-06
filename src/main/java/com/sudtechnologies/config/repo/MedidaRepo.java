package com.sudtechnologies.config.repo;

import com.sudtechnologies.config.entity.UnidadMedida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Usuario on 3/11/2017.
 */
public interface MedidaRepo extends CrudRepository<UnidadMedida, Long> {
    @Query("select m from UnidadMedida m where m.estado = 1")
    List<UnidadMedida> buscarTodos();
}
