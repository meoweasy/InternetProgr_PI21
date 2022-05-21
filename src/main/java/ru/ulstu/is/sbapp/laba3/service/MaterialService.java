package ru.ulstu.is.sbapp.laba3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ulstu.is.sbapp.laba3.model.Material;
import ru.ulstu.is.sbapp.laba3.repository.IMaterialRepository;
import ru.ulstu.is.sbapp.util.validation.ValidatorUtil;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    private final IMaterialRepository materialRepository;
    private  final ValidatorUtil validatorUtil;
    public MaterialService(IMaterialRepository materialRepository,ValidatorUtil validatorUtil){
        this.materialRepository = materialRepository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public Material addMaterial(String name) {
        final Material mat = new Material(name);
        validatorUtil.validate(mat);
        return materialRepository.save(mat);
    }

    @Transactional(readOnly = true)
    public Material findMaterial(Long id) {
        final Optional<Material> mat = materialRepository.findById(id);
        return mat.orElseThrow(() -> new MaterialNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Material> findAllMaterials() {
        return materialRepository.findAll();
    }

    @Transactional
    public Material updateMaterial(Long id, String name) {
        final Material currentMaterial = findMaterial(id);
        currentMaterial.setName(name);
        validatorUtil.validate(currentMaterial);
        return materialRepository.save(currentMaterial);
    }

    @Transactional
    public Material deleteMaterial(Long id) {
        final Material currentMaterial = findMaterial(id);
        materialRepository.delete(currentMaterial);
        return currentMaterial;
    }

    @Transactional
    public void deleteAllMaterials() {
        materialRepository.deleteAll();
    }
}

