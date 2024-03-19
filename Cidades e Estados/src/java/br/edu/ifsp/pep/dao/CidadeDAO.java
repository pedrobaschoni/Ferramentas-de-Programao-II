package br.edu.ifsp.pep.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CidadeDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
}
