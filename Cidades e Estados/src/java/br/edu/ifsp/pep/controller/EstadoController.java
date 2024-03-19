/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.EstadoDAO;
import br.edu.ifsp.pep.model.Estado;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class EstadoController {
    
    @EJB
    private EstadoDAO estadoDao;
    
    private List<Estado> estados;
    
    private Estado estadoSelecionado;
    
    public void exibir(){
        System.out.println(estadoSelecionado);
    }
  
    
    public List<Estado> buscarTodos(){
        return estadoDao.buscar();
    }

    public EstadoDAO getEstadoDao() {
        return estadoDao;
    }

    public void setEstadoDao(EstadoDAO estadoDao) {
        this.estadoDao = estadoDao;
    }

    public Estado getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Estado estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
    
}
