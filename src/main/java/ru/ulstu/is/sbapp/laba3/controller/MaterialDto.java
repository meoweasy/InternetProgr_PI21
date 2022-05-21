package ru.ulstu.is.sbapp.laba3.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ulstu.is.sbapp.laba3.model.Material;

import javax.validation.constraints.NotBlank;

public class MaterialDto {
    private long id;
    @NotBlank(message = "Material name can't be null or empty")
    private String name;

    public MaterialDto(){
    }

    public MaterialDto(Material material) {
        this.id = material.getId();
        this.name = material.getName();
    }
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
