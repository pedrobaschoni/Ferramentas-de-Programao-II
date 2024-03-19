package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CidadeDAO;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class CidadeController {
    
    @EJB
    private CidadeDAO cidadeDAO;
    
}
