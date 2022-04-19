package ru.ulstu.is.sbapp.laba3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class WarehouseService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Warehouse addWarehouse(int id,int MaterialId,int TypeWarehouseId) {
        final Warehouse warehouse = new Warehouse(id,MaterialId,TypeWarehouseId);
        em.persist(warehouse);
        return warehouse;
    }

    @Transactional(readOnly = true)
    public Warehouse findWarehouse(int id) {
        final Warehouse warehouse = em.find(Warehouse.class, id);
        if (warehouse == null) {
            throw new EntityNotFoundException(String.format("Warehouse with id [%s] is not found", id));
        }
        return warehouse;
    }
    @Transactional(readOnly = true)
    public List<Warehouse> findAllWarehouses() {
        return em.createQuery("select s from Warehouse s", Warehouse.class)
                .getResultList();
    }


    @Transactional
    public Warehouse updateWarehouse(int id) {
        final Warehouse currentWarehouse = findWarehouse(id);
        return em.merge(currentWarehouse);
    }

    @Transactional
    public Warehouse deleteWarehouse(int id) {
        final Warehouse currentWarehouse = findWarehouse(id);
        em.remove(currentWarehouse);
        return currentWarehouse;
    }
}
