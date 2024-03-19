package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CursoDao {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void persist (Curso curso) {
        em.persist(curso);
    }
    
    public List<Curso> findAll() {
        return em.createNamedQuery("Curso.findAll", Curso.class).getResultList();
    }
    
    public Curso findById(Integer id) {
        return em.find(Curso.class, id);
    }
}
