package ru.ulstu.is.sbapp.laba3.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TypeWarehouse {
    @Id
    private int id;
    private String name;

    public TypeWarehouse(){
    }

    public TypeWarehouse(int id,String name) {
        this.id = id;
        this.name=name;
    }
    public int getId() {
        return id;
    }
    public void setName(String Name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeWarehouse typeWarehouse = (TypeWarehouse) o;
        return Objects.equals(id, typeWarehouse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TypeWarehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
