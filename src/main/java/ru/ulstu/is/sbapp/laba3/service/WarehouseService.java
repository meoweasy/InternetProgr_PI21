package ru.ulstu.is.sbapp.laba3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;
import ru.ulstu.is.sbapp.laba3.repository.IWarehouseRepository;
import ru.ulstu.is.sbapp.util.validation.ValidatorUtil;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private final IWarehouseRepository warehouseRepository;
    private final ValidatorUtil validatorUtil;
    public WarehouseService(IWarehouseRepository warehouseRepository,ValidatorUtil validatorUtil){
        this.warehouseRepository = warehouseRepository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public Warehouse addWarehouse(Long MaterialId,Long TypeWarehouseId) {
        final Warehouse war = new Warehouse(MaterialId,TypeWarehouseId);
        validatorUtil.validate(war);
        return warehouseRepository.save(war);
    }

    @Transactional(readOnly = true)
    public Warehouse findWarehouse(Long id) {
        final Optional<Warehouse> war = warehouseRepository.findById(id);
        return war.orElseThrow(() -> new WarehouseNotFoundException(id));
    }
    @Transactional(readOnly = true)
    public List<Warehouse> findAllWarehouses() {
        return warehouseRepository.findAll();
    }
    @Transactional
    public Warehouse updateWarehouse(Long id, Long MaterialId, Long TypeWarehouseId) {
        final Warehouse currentWarehouse = findWarehouse(id);
        currentWarehouse.setMaterialId(MaterialId);
        currentWarehouse.setTypeWarehouseId(TypeWarehouseId);
        validatorUtil.validate(currentWarehouse);
        return warehouseRepository.save(currentWarehouse);
    }

    @Transactional
    public Warehouse deleteWarehouse(Long id) {
        final Warehouse currentWarehouse = findWarehouse(id);
        warehouseRepository.delete(currentWarehouse);
        return currentWarehouse;
    }
    @Transactional
    public void deleteAllWarehouses() {
        warehouseRepository.deleteAll();
    }
}
