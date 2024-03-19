package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Tarefa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TarefaDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void inserir(Tarefa tarefa) {
        em.persist(tarefa);
    }
    
    public void remover(Tarefa tarefa) {
        em.remove(em.merge(tarefa));
    }
    
    public List<Tarefa> findAll() {
        return em.createQuery("SELECT t FROM Tarefa t", 
                Tarefa.class)
                .getResultList();
    }
}
