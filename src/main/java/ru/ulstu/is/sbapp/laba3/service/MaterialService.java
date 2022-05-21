package ru.ulstu.is.sbapp.laba3.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.ulstu.is.sbapp.laba3.model.Material;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class MaterialService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Material addMaterial(String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Material name is null or empty");
        }
        final Material material = new Material(name);
        em.persist(material);
        return material;
    }

    @Transactional(readOnly = true)
    public Material findMaterial(Long id) {
        final Material material = em.find(Material.class, id);
        if (material == null) {
            throw new EntityNotFoundException(String.format("Material with id [%s] is not found", id));
        }
        return material;
    }

    @Transactional(readOnly = true)
    public List<Material> findAllMaterials() {
        return em.createQuery("select s from Material s", Material.class)
                .getResultList();
    }

    @Transactional
    public Material updateMaterial(Long id, String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Material name is null or empty");
        }
        final Material currentMaterial = findMaterial(id);
        currentMaterial.setName(name);
        return em.merge(currentMaterial);
    }

    @Transactional
    public Material deleteMaterial(Long id) {
        final Material currentMaterial = findMaterial(id);
        em.remove(currentMaterial);
        return currentMaterial;
    }

    @Transactional
    public void deleteAllMaterials() {
        em.createQuery("delete from Material").executeUpdate();
    }
}

