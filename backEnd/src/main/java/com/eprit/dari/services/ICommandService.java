package com.eprit.dari.services;

import com.eprit.dari.entities.Command;
import com.itextpdf.text.DocumentException;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;

public interface ICommandService {

    public void ajouterCommand(Long user, String code, Boolean transporterValidation) throws FileNotFoundException, DocumentException, MessagingException;
    public void deleteCommandById(Long commandId);
    public List<Command> getAllCommand();

}
