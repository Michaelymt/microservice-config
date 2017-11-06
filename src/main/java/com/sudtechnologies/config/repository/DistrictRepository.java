package com.sudtechnologies.config.repository;

import com.sudtechnologies.config.entity.District;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository extends CrudRepository<District, Long> {

    @Query("select d from District d where d.state = 1")
    List<District> findAll();

    @Query("select d from District d where d.id = :id")
    District findById(@Param("id") Long id);

    @Query("delete from District d where d.id = :id")
    @Modifying
    void deleteById(@Param("id") Long id);
}
