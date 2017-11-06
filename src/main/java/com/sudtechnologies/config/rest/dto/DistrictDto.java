package com.sudtechnologies.config.rest.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class DistrictDto {

    @NotEmpty
    @Size(max = 50)
    private String name;

    private Long userCreated;

    public DistrictDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Long userCreated) {
        this.userCreated = userCreated;
    }
}
