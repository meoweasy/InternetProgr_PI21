package ru.ulstu.is.sbapp.laba3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Warehouse {
    @Id
    private int id;
    private int MaterialId;
    private int TypeWarehouseId;

    public Warehouse() {
    }

    public Warehouse(int id,int MaterialId,int TypeWarehouseId) {
        this.id=id;
        this.MaterialId=MaterialId;
        this.TypeWarehouseId=TypeWarehouseId;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(id, warehouse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", MaterialId='" + MaterialId + '\'' +
                ", TypeWarehouseId='" + TypeWarehouseId + '\'' +
                '}';
    }
}
