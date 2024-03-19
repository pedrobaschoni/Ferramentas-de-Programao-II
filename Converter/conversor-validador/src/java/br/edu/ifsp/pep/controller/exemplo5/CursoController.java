package br.edu.ifsp.pep.controller.exemplo5;

import br.edu.ifsp.pep.dao.CursoDao;
import br.edu.ifsp.pep.model.Curso;
import br.edu.ifsp.pep.util.Util;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CursoController {
    
    @EJB
    private CursoDao cursoDao;
    
    private Curso curso = new Curso();
    
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }
    
    public Curso findById(Integer id) {
        return cursoDao.findById(id);
    }
    
    public void teste() {
        System.out.println("teste");
        System.out.println(curso);
    }
    
    public void cadastrar() {
        
        if (!curso.getDuracao().equals(20) &&
                !curso.getDuracao().equals(40) &&
                !curso.getDuracao().equals(80)) {
            Util.warn("A Duração do curso deve ser 20, 40 ou 80 horas.");
            return;
        }
        if (!curso.getDataInicio().isBefore(curso.getDataTermino())) {
            Util.warn("A Data de Início deve ser inferior a Data de Término.");
            return;
        }
        
        cursoDao.persist(curso);
        curso = new Curso();
        
        Util.info("Curso cadastrado!");
        
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
}
