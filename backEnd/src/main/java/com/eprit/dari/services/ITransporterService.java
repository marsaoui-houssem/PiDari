package com.eprit.dari.services;

import com.eprit.dari.entities.Transportor;

import java.util.List;

public interface ITransporterService {

    public Long ajouterCommand(Transportor transportor);
    public void deleteCommandById(Long transportorId);
    public List<Transportor> getAllCommand();
    public void affecterTransporterToCommand(Long transportorId, Long commandId);
    public void changeCommandEtatAndTransporter(Long commandId , Long transporterId);
}
