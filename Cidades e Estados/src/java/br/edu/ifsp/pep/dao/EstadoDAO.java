/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Estado;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class EstadoDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public List<Estado> buscar(){
        return em.createNamedQuery("Estado.buscar",Estado.class).getResultList();
    }
}
