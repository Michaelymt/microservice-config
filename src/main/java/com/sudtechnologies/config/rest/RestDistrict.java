package com.sudtechnologies.config.rest;

import com.sudtechnologies.config.rest.dto.DistrictDto;
import com.sudtechnologies.config.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1/public/district")
public class RestDistrict {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity(districtService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(Long id) {
        return new ResponseEntity(districtService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDistrict(@RequestParam(required = false, defaultValue = "") Long userCreated,
                                            @Valid @RequestBody DistrictDto dto) {
        return new ResponseEntity(districtService.add(dto), HttpStatus.CREATED);
    }

    /*@PostMapping
    public ResponseEntity<?> updateDistrict(@RequestParam(required = false, defaultValue = "") Long userCreated,
                                            @Valid @RequestBody DistrictDto dto) {
        return new ResponseEntity(districtService.update(dto), HttpStatus.OK);
    }*/


    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<?> eliminarDireccion(@PathVariable Long id) {
        districtService.delete(id);
        return new ResponseEntity("Ok", HttpStatus.OK);
    }

}


