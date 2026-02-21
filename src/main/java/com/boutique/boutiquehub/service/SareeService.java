package com.boutique.boutiquehub.service;



import java.util.List;
import com.boutique.boutiquehub.entity.Saree;

public interface SareeService {

    Saree addSaree(Saree saree);          // POST

    List<Saree> getAllSarees();            // GET ALL

    Saree getSareeById(long id);           // GET BY ID

    Saree updateSaree(long id, Saree saree); // PUT

    void deleteSaree(long id);             // DELETE
}

