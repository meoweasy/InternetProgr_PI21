package ru.ulstu.is.sbapp.laba3.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;
import ru.ulstu.is.sbapp.laba3.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;


    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouse(@PathVariable Long id) {
        return warehouseService.findWarehouse(id);
    }

    @GetMapping("/")
    public List<Warehouse> getWarehouses() {
        return warehouseService.findAllWarehouses();
    }

    @PostMapping("/")
    public Warehouse createWarehouse(@RequestParam("MaterialID") Long MaterialId,
                                     @RequestParam("TypeWarehouseID") Long TypeWarehouseId) {
        return warehouseService.addWarehouse(MaterialId,TypeWarehouseId);
    }

    @PatchMapping("/{id}")
    public Warehouse updateWarehouse(@PathVariable Long id,
                                     @RequestParam("MaterialID") Long MaterialId,
                                     @RequestParam("TypeWarehouseID") Long TypeWarehouseId) {
        return warehouseService.updateWarehouse(id,MaterialId,TypeWarehouseId);
    }

    @DeleteMapping("/{id}")
    public Warehouse deleteWarehouse(@PathVariable Long id) {
        return warehouseService.deleteWarehouse(id);
    }
}
