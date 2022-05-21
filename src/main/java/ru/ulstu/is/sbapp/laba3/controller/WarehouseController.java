package ru.ulstu.is.sbapp.laba3.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.WebConfiguration;
import ru.ulstu.is.sbapp.laba3.service.WarehouseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebConfiguration.REST_API +"/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/{id}")
    public WarehouseDto getWarehouse(@PathVariable Long id) {
        return new  WarehouseDto(warehouseService.findWarehouse(id));
    }

    @GetMapping("/")
    public List<WarehouseDto> getWarehouses() {
        return warehouseService.findAllWarehouses().stream().map(WarehouseDto::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    public WarehouseDto createWarehouse(@RequestParam("MaterialId") Long MaterialId,
                                        @RequestParam("TypeWarehouseId") Long TypeWarehouseId) {
        return new WarehouseDto((warehouseService.addWarehouse(MaterialId,TypeWarehouseId)));
    }

    @PutMapping("/{id}")
    public WarehouseDto updateWarehouse(@PathVariable Long id,
                                        @RequestParam("MaterialId") Long MaterialId,
                                        @RequestParam("TypeWarehouseId") Long TypeWarehouseId) {
        return new WarehouseDto(warehouseService.updateWarehouse(id, MaterialId,TypeWarehouseId));
    }

    @DeleteMapping("/{id}")
    public WarehouseDto deleteWarehouse(@PathVariable Long id) {
        return new WarehouseDto(warehouseService.deleteWarehouse(id));
    }
}
