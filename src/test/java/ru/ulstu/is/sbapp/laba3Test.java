package ru.ulstu.is.sbapp;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ulstu.is.sbapp.laba3.model.Material;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;
import ru.ulstu.is.sbapp.laba3.service.MaterialService;
import ru.ulstu.is.sbapp.laba3.service.TypeWarehouseService;
import ru.ulstu.is.sbapp.laba3.service.WarehouseService;

@SpringBootTest
public class laba3Test {
    private static final Logger log = LoggerFactory.getLogger(JpaStudentTest.class);

    @Autowired
    private MaterialService materialService;
    @Autowired
    private TypeWarehouseService typeWarehouseService;
    @Autowired
    private WarehouseService warehouseService;
    ///3 лаба
    @Test
    void Add(){
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material m1 = materialService.addMaterial(1,"доска");
        log.info(m1.toString());
        final Material m2 = materialService.addMaterial(2,"винт");
        log.info(m2.toString());
        final Material m3 = materialService.addMaterial(3,"стол");
        log.info(m3.toString());
        final TypeWarehouse tw1 = typeWarehouseService.addTypeWarehouse(1,"склад готовой продукции");
        log.info(tw1.toString());
        final TypeWarehouse tw2 = typeWarehouseService.addTypeWarehouse(2,"склад материалов");
        log.info(tw2.toString());
        final Warehouse w1 = warehouseService.addWarehouse(1,m1.getId(), tw2.getId());
        log.info(w1.toString());
        final Warehouse w2 = warehouseService.addWarehouse(2,m2.getId(), tw2.getId());
        log.info(w2.toString());
        final Warehouse w3 = warehouseService.addWarehouse(3,m3.getId(), tw1.getId());
        log.info(w3.toString());
    }

}