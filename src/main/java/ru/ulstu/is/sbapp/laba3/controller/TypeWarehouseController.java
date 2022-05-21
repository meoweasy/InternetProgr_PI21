package ru.ulstu.is.sbapp.laba3.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;
import ru.ulstu.is.sbapp.laba3.service.TypeWarehouseService;

import java.util.List;

@RestController
@RequestMapping("/typewarehouse")
public class TypeWarehouseController {
    private final TypeWarehouseService typeWarehouseService;


    public TypeWarehouseController(TypeWarehouseService typeWarehouseService) {
        this.typeWarehouseService = typeWarehouseService;
    }

    @GetMapping("/{id}")
    public TypeWarehouse getTypeWarehouse(@PathVariable Long id) {
        return typeWarehouseService.findTypeWarehouse(id);
    }

    @GetMapping("/")
    public List<TypeWarehouse> geTypeWarehouses() {
        return typeWarehouseService.findAllTypeWarehouses();
    }

    @PostMapping("/")
    public TypeWarehouse createTypeWarehouse(@RequestParam("name") String name) {
        return typeWarehouseService.addTypeWarehouse(name);
    }

    @PatchMapping("/{id}")
    public TypeWarehouse updateTypeWarehouse(@PathVariable Long id,
                                   @RequestParam("name") String name) {
        return typeWarehouseService.updateTypeWarehouse(id, name);
    }

    @DeleteMapping("/{id}")
    public TypeWarehouse deleteTypeWarehouse(@PathVariable Long id) {
        return typeWarehouseService.deleteTypeWarehouse(id);
    }
}
