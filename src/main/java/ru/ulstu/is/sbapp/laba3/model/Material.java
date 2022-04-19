package ru.ulstu.is.sbapp.laba3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Material {
    @Id
    private int id;
    private String name;

    public Material() {
    }

    public Material(int id,String name) {
        this.id=id;
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
        Material material = (Material) o;
        return Objects.equals(id, material.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
