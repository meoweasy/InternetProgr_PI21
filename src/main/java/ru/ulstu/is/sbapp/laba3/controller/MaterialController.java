package ru.ulstu.is.sbapp.laba3.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.laba3.model.Material;
import ru.ulstu.is.sbapp.laba3.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    private final MaterialService materialService;


    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/{id}")
    public Material getMaterial(@PathVariable Long id) {
        return materialService.findMaterial(id);
    }

    @GetMapping("/")
    public List<Material> geMaterials() {
        return materialService.findAllMaterials();
    }

    @PostMapping("/")
    public Material createMaterial(@RequestParam("name") String name) {
        return materialService.addMaterial(name);
    }

    @PatchMapping("/{id}")
    public Material updateMaterial(@PathVariable Long id,
                                 @RequestParam("name") String name) {
        return materialService.updateMaterial(id, name);
    }

    @DeleteMapping("/{id}")
    public Material deleteMaterial(@PathVariable Long id) {
        return materialService.deleteMaterial(id);
    }
}
