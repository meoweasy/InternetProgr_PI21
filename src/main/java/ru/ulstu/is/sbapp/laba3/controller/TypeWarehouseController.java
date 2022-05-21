package ru.ulstu.is.sbapp.laba3.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.WebConfiguration;
import ru.ulstu.is.sbapp.laba3.service.TypeWarehouseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebConfiguration.REST_API + "/typeWarehouse")
public class TypeWarehouseController {
    private final TypeWarehouseService typeWarehouseService;


    public TypeWarehouseController(TypeWarehouseService typeWarehouseService) {
        this.typeWarehouseService = typeWarehouseService;
    }

    @GetMapping("/{id}")
    public TypeWarehouseDto getTypeWarehouse(@PathVariable Long id) {
        return new TypeWarehouseDto(typeWarehouseService.findTypeWarehouse(id));
    }

    @GetMapping("/")
    public List<TypeWarehouseDto> getTypeWarehouses() {
        return typeWarehouseService.findAllTypeWarehouses().stream().map(TypeWarehouseDto::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    public TypeWarehouseDto createTypeWarehouse(@RequestParam("name") String name) {
        return new TypeWarehouseDto(typeWarehouseService.addTypeWarehouse(name));
    }

    @PutMapping("/{id}")
    public TypeWarehouseDto updateTypeWarehouse(@PathVariable Long id,
                                                @RequestParam("name") String name) {
        return new TypeWarehouseDto(typeWarehouseService.updateTypeWarehouse(id, name));
    }

    @DeleteMapping("/{id}")
    public TypeWarehouseDto deleteTypeWarehouse(@PathVariable Long id) {
        return new TypeWarehouseDto(typeWarehouseService.deleteTypeWarehouse(id));
    }
}
