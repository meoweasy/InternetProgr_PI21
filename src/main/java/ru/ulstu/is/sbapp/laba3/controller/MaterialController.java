package ru.ulstu.is.sbapp.laba3.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.WebConfiguration;
import ru.ulstu.is.sbapp.laba3.service.MaterialService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebConfiguration.REST_API+"/material")
public class MaterialController {
    private final MaterialService materialService;


    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/{id}")
    public MaterialDto getMaterial(@PathVariable Long id) {
        return new MaterialDto(materialService.findMaterial(id));
    }

    @GetMapping("/")
    public List<MaterialDto> geMaterials() {
        return materialService.findAllMaterials().stream().map(MaterialDto::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    public MaterialDto createMaterial(@RequestBody @Valid MaterialDto materialDto) {
        return new MaterialDto(materialService.addMaterial(materialDto.getName()));
    }

    @PutMapping("/{id}")
    public MaterialDto updateMaterial(@PathVariable Long id,
                                      @RequestBody @Valid MaterialDto materialDto) {
        return new MaterialDto(materialService.updateMaterial(id, materialDto.getName()));
    }

    @DeleteMapping("/{id}")
    public MaterialDto deleteMaterial(@PathVariable Long id) {
        return new MaterialDto(materialService.deleteMaterial(id));
    }
}
