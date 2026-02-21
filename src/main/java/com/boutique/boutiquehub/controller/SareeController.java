package com.boutique.boutiquehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boutique.boutiquehub.entity.Saree;
import com.boutique.boutiquehub.service.SareeService;

@RestController
@RequestMapping("/api/sarees")
public class SareeController {

    @Autowired
    private SareeService sareeService;

    // ✅ POST - Add Saree
    @PostMapping
    public Saree addSaree(@RequestBody Saree saree) {
        return sareeService.addSaree(saree);
    }

    // ✅ GET ALL - Fetch all sarees
    @GetMapping
    public List<Saree> getAllSarees() {
        return sareeService.getAllSarees();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public Saree getSareeById(@PathVariable long id) {
        return sareeService.getSareeById(id);
    }

    // ✅ PUT - Update
    @PutMapping("/{id}")
    public Saree updateSaree(@PathVariable long id, @RequestBody Saree saree) {
        return sareeService.updateSaree(id, saree);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteSaree(@PathVariable long id) {
        sareeService.deleteSaree(id);
        return "Saree deleted successfully!";
    }
}

