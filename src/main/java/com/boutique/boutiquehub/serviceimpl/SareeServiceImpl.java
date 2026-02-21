package com.boutique.boutiquehub.serviceimpl;


import java.util.List;

import com.boutique.boutiquehub.service.SareeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.boutiquehub.entity.Saree;
import com.boutique.boutiquehub.repository.SareeRepository;

@Service
public class SareeServiceImpl implements SareeService {

    @Autowired
    private SareeRepository sareeRepository;

    // POST
    @Override
    public Saree addSaree(Saree saree) {
        return sareeRepository.save(saree);
    }

    // GET ALL
    @Override
    public List<Saree> getAllSarees() {
        return sareeRepository.findAll();
    }

    // GET BY ID
    @Override
    public Saree getSareeById(long id) {
        return sareeRepository.findById(id).orElse(null);
    }

    // PUT
    @Override
    public Saree updateSaree(long id, Saree saree) {

        Saree existing = sareeRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(saree.getName());
            existing.setDescription(saree.getDescription());
            existing.setColor(saree.getColor());
            existing.setPrice(saree.getPrice());
            existing.setStock(saree.getStock());
            existing.setImgUrl(saree.getImgUrl());

            return sareeRepository.save(existing);
        }

        return null;
    }

    // DELETE
    @Override
    public void deleteSaree(long id) {
        sareeRepository.deleteById(id);
    }
}

