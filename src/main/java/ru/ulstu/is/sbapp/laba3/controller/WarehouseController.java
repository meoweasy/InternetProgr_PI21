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
    public Warehouse getWarehouse(@PathVariable int id) {
        return warehouseService.findWarehouse(id);
    }

    @GetMapping("/")
    public List<Warehouse> getWarehouses() {
        return warehouseService.findAllWarehouses();
    }

    @PostMapping("/")
    public Warehouse createWarehouse(@RequestParam("id") int id,
                                     @RequestParam("MaterialID") int MaterialId,
                                     @RequestParam("TypeWarehouseID") int TypeWarehouseId) {
        return warehouseService.addWarehouse(id,MaterialId,TypeWarehouseId);
    }

    @PatchMapping("/{id}")
    public Warehouse updateWarehouse(@PathVariable int id) {
        return warehouseService.updateWarehouse(id);
    }

    @DeleteMapping("/{id}")
    public Warehouse deleteWarehouse(@PathVariable int id) {
        return warehouseService.deleteWarehouse(id);
    }
}
