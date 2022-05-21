package ru.ulstu.is.sbapp.laba3.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;

public class WarehouseDto {
    private long id;
    private long MaterialId;
    private long TypeWarehouseId;

    public WarehouseDto(){
    }

    public WarehouseDto(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.MaterialId = warehouse.getMaterialId();
        this.TypeWarehouseId = warehouse.getTypeWarehouseId();
    }
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return id;
    }

    public long getMaterialId(){ return MaterialId;}
    public long getTypeWarehouseId(){ return TypeWarehouseId;}
    public void setMaterialId(Long MaterialId) {
        this.MaterialId = MaterialId;
    }
    public void setTypeWarehouseId(Long TypeWarehouseId) {
        this.TypeWarehouseId = TypeWarehouseId;
    }
}