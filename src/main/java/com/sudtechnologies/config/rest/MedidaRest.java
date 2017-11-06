package com.sudtechnologies.config.rest;


import com.sudtechnologies.config.service.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Usuario on 3/11/2017.
 */
@RestController
@RequestMapping("/rest/v1/public/medida")
public class MedidaRest {

    @Autowired
    private UnidadMedidaService medidaService;

    @GetMapping
    public ResponseEntity<?> getMedida() {
        return new ResponseEntity(medidaService.obtenerActivos(), HttpStatus.OK);
    }

/*
    @GetMapping("/hola")
    public ResponseEntity<?> hola() {
        UnidadMedida m = new UnidadMedida(1L, "Kilogramos",1l,"fdfadfaf" ,true);
        return new ResponseEntity(m, HttpStatus.OK);
    }*/

}
