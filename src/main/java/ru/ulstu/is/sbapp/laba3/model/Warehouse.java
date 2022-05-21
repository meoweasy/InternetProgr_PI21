package ru.ulstu.is.sbapp.laba3.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    private Long MaterialId;
    private Long TypeWarehouseId;

    public Warehouse() {
    }

    public Warehouse(Long MaterialId,Long TypeWarehouseId) {
        this.MaterialId=MaterialId;
        this.TypeWarehouseId=TypeWarehouseId;
    }

    public Long getId() {
        return id;
    }
    public Long getMaterialId() {
        return MaterialId;
    }

    public void setMaterialId(Long MaterialId) {
        this.MaterialId=MaterialId;
    }

    public Long getTypeWarehouseId() {
        return TypeWarehouseId;
    }

    public void setTypeWarehouseId(Long TypeWarehouseId) {
        this.TypeWarehouseId = TypeWarehouseId;
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
