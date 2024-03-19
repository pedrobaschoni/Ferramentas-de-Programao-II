package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.TarefaDAO;
import br.edu.ifsp.pep.model.Tarefa;
import br.edu.ifsp.pep.util.Util;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class TarefaController implements Serializable{
    
    @EJB
    private TarefaDAO tarefaDAO;
    
    private List<Tarefa> tarefas = new ArrayList<>();
    private Tarefa tarefa;
    private Tarefa tarefaSelecionada;

    public List<Tarefa> findAll() {
        return tarefaDAO.findAll();
    }
    
    public void cadastrar() {
        
        if(!tarefa.getDataCadastro().isBefore(tarefa.getDataModificacao())) {
            Util.warn("A data de Modificação deve ser maior que a data de cadastro");
        }
        
        tarefa.setStatus("Cadastrada");
        
        tarefaDAO.inserir(tarefa);
        tarefa = new Tarefa();
        
        Util.info("Tarefa Cadastrada");
    }
    
    public void remover() {
        
        if(tarefaSelecionada.getStatus().equals("Cancelada")) {
            tarefaDAO.remover(tarefaSelecionada);
            Util.info("Tarefa removida com sucesso");
        } else {
            Util.warn("A tarefa deve estar cancelada para ser removida");
        }
        
    }
    
    public void cancelar() {
        
        if(tarefaSelecionada.getStatus().equals("Cadastrada")) {
            tarefaSelecionada.setStatus("Cancelada");
            Util.info("Tarefa cancelada com sucesso");
        } else {
            Util.warn("Você só pode cancelar tarefas cadastradas");
        }
    }
    
    public void finalizar() {
        
        if(tarefaSelecionada.getStatus().equals("Cadastrada")) {
            tarefaSelecionada.setStatus("Finalizada");
            Util.info("Tarefa finalizada com sucesso");
        } else {
            Util.warn("Você só pode finalizar tarefas que não foram canceladas");
        }
    }
    
    private void inserirTarefas() {
        for (Tarefa tarefa : tarefas) {
            tarefaDAO.inserir(tarefa);
        }
    }

    public List<Tarefa> getTarefas() {
        
        if(tarefas == null) {
            tarefas = tarefaDAO.findAll();
        }
        
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Tarefa getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

}
