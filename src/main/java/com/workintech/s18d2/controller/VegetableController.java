package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping()
    public List<Vegetable> getByPriceAsc(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@Positive @PathVariable Long id){
        return vegetableService.getById(id);
    }

    @GetMapping()
    public List<Vegetable> getByPriceDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable Long id){
        return vegetableService.delete(id);
    }
}