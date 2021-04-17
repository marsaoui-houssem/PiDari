package com.esprit.dari.services.furnituresServices;

import com.esprit.dari.entities.furnituresEntities.Transportor;

import java.util.List;

public interface ITransporterService {

    public Long ajouterCommand(Transportor transportor);
    public void deleteCommandById(Long transportorId);
    public List<Transportor> getAllCommand();
    public void affecterTransporterToCommand(Long transportorId, Long commandId);
    public void changeCommandEtatAndTransporter(Long commandId , Long transporterId);
}
