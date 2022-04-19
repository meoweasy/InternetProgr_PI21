package ru.ulstu.is.sbapp.laba3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TypeWarehouseService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public TypeWarehouse addTypeWarehouse(int id, String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("TypeWarehouse name is null or empty");
        }
        final TypeWarehouse typeWarehouse = new TypeWarehouse(id, name);
        em.persist(typeWarehouse);
        return typeWarehouse;
    }

    @Transactional(readOnly = true)
    public TypeWarehouse findTypeWarehouse(int id) {
        final TypeWarehouse typeWarehouse = em.find(TypeWarehouse.class, id);
        if (typeWarehouse == null) {
            throw new EntityNotFoundException(String.format("typeWarehouse with id [%s] is not found", id));
        }
        return typeWarehouse;
    }

    @Transactional(readOnly = true)
    public List<TypeWarehouse> findAllTypeWarehouses() {
        return em.createQuery("select s from TypeWarehouse s", TypeWarehouse.class)
                .getResultList();
    }

    @Transactional
    public TypeWarehouse updateTypeWarehouse(int id, String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("TypeWarehouse name is null or empty");
        }
        final TypeWarehouse currentTypeWarehouse = findTypeWarehouse(id);
        currentTypeWarehouse.setName(name);
        return em.merge(currentTypeWarehouse);
    }

    @Transactional
    public TypeWarehouse deleteTypeWarehouse(int id) {
        final TypeWarehouse currentTypeWarehouse = findTypeWarehouse(id);
        em.remove(currentTypeWarehouse);
        return currentTypeWarehouse;
    }

    @Transactional
    public void deleteAllTypeWarehouses() {
        em.createQuery("delete from TypeWarehouse").executeUpdate();
    }
}
