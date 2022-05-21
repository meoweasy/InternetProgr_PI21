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
    public Warehouse addWarehouse(Long MaterialId,Long TypeWarehouseId) {
        if (!(MaterialId != null) || !(TypeWarehouseId != null)){
            throw new IllegalArgumentException("Id's is null or empty");
        }
        final Warehouse warehouse = new Warehouse(MaterialId,TypeWarehouseId);
        em.persist(warehouse);
        return warehouse;
    }

    @Transactional(readOnly = true)
    public Warehouse findWarehouse(Long id) {
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
    public Warehouse updateWarehouse(Long id, Long MaterialId, Long TypeWarehouseId) {
        if (!(MaterialId == null) || !(TypeWarehouseId == null)){
            throw  new IllegalArgumentException("Warehouse Id's is null or empty");
        }
        final Warehouse currentWarehouse = findWarehouse(id);
        currentWarehouse.setMaterialId(MaterialId);
        currentWarehouse.setTypeWarehouseId(TypeWarehouseId);
        return em.merge(currentWarehouse);
    }

    @Transactional
    public Warehouse deleteWarehouse(Long id) {
        final Warehouse currentWarehouse = findWarehouse(id);
        em.remove(currentWarehouse);
        return currentWarehouse;
    }
    @Transactional
    public void deleteAllWarehouses() {
        em.createQuery("delete from Warehouse").executeUpdate();
    }
}
