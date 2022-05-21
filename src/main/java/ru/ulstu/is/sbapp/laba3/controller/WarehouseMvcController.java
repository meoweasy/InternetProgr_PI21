package ru.ulstu.is.sbapp.laba3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.laba3.service.WarehouseService;

import javax.validation.Valid;

@Controller
@RequestMapping("/warehouse")
public class WarehouseMvcController {
    private final WarehouseService warehouseService;
    public WarehouseMvcController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }
    @GetMapping
    public String getWarehouses(Model model){
        model.addAttribute("warehouse",warehouseService.findAllWarehouses());
        return "warehouse";
    }
    @GetMapping(value = {"/edit","/edit/{id}"})
    public String editWarehouse(@PathVariable(required = false) Long id,
                               Model model){
        if (id == null || id<=0){
            model.addAttribute("warehouseDto",new WarehouseDto());
        } else{
            model.addAttribute("warehouseId",id);
            model.addAttribute("warehouseDto",new WarehouseDto(warehouseService.findWarehouse(id)));
        }
        return "warehouse-edit";
    }

    @PostMapping(value = {"","/{id}"})
    public String saveWarehouse(@PathVariable(required = false) Long id,
                               @ModelAttribute @Valid WarehouseDto warehouseDto,
                               BindingResult bindingResult,
                               Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "warehouse-edit";
        }
        if (id == null || id <= 0) {
            warehouseService.addWarehouse(warehouseDto.getMaterialId(), warehouseDto.getTypeWarehouseId());
        } else {
            warehouseService.updateWarehouse(id,warehouseDto.getMaterialId(), warehouseDto.getTypeWarehouseId());
        }
        return "redirect:/warehouse";
    }
    @PostMapping("/delete/{id}")
    public String deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return "redirect:/warehouse";
    }
}
