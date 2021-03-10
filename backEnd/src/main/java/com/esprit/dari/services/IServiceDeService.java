package com.esprit.dari.services;

import com.esprit.dari.entities.OffreService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IServiceDeService {

    public int  ajoutService( OffreService serv);
    public List<OffreService> getAllService();
    public OffreService getByIdService (int id );
    public void deleteService(int id);
    public void affecteServiceAabonn (int idAbon, int idServ  );
}
