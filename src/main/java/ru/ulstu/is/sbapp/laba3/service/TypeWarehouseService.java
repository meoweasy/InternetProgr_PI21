package ru.ulstu.is.sbapp.laba3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;
import ru.ulstu.is.sbapp.laba3.repository.ITypeWarehouseRepository;
import ru.ulstu.is.sbapp.util.validation.ValidatorUtil;

import java.util.List;
import java.util.Optional;

@Service
public class TypeWarehouseService {
    private final ITypeWarehouseRepository typeWarehouseRepository;
    private final ValidatorUtil validatorUtil;

    public TypeWarehouseService(ITypeWarehouseRepository typeWarehouseRepository,ValidatorUtil validatorUtil){
        this.typeWarehouseRepository = typeWarehouseRepository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public TypeWarehouse addTypeWarehouse(String name) {
        final TypeWarehouse tw = new TypeWarehouse(name);
        validatorUtil.validate(tw);
        return typeWarehouseRepository.save(tw);
    }

    @Transactional(readOnly = true)
    public TypeWarehouse findTypeWarehouse(Long id) {
        final Optional<TypeWarehouse> tw = typeWarehouseRepository.findById(id);
        return tw.orElseThrow(() -> new TypeWarehouseNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<TypeWarehouse> findAllTypeWarehouses() {
        return typeWarehouseRepository.findAll();
    }

    @Transactional
    public TypeWarehouse updateTypeWarehouse(Long id, String name) {
        final TypeWarehouse currentTypeWarehouse = findTypeWarehouse(id);
        currentTypeWarehouse.setName(name);
        validatorUtil.validate(currentTypeWarehouse);
        return typeWarehouseRepository.save(currentTypeWarehouse);
    }

    @Transactional
    public TypeWarehouse deleteTypeWarehouse(Long id) {
        final TypeWarehouse currentTypeWarehouse = findTypeWarehouse(id);
        typeWarehouseRepository.delete(currentTypeWarehouse);
        return currentTypeWarehouse;
    }

    @Transactional
    public void deleteAllTypeWarehouses() {
        typeWarehouseRepository.deleteAll();
    }
}
