package ru.ulstu.is.sbapp.laba3.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;

import javax.validation.constraints.NotBlank;

public class TypeWarehouseDto {
    private long id;
    @NotBlank(message = "Type warehouse name can't be null or empty")
    private String name;

    public TypeWarehouseDto(){
    }

    public TypeWarehouseDto(TypeWarehouse typeWarehouse) {
        this.id = typeWarehouse.getId();
        this.name = typeWarehouse.getName();
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
