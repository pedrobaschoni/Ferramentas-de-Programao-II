package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Aplicacao;
import br.edu.ifsp.pep.util.Util;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class AplicacaoController implements Serializable{
    
    private Aplicacao aplicacao = new Aplicacao();
    private List<Aplicacao> aplicacoes = new ArrayList<>();

    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public List<Aplicacao> getAplicacoes() {
        return aplicacoes;
    }

    public void setAplicacoes(List<Aplicacao> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }
    
    public void calcularAplicacao() {
        
        
        aplicacao.calcularRendaBruta();
        
        if(aplicacao.getTipo().equals("CDB")) {
            aplicacao.calcularImpostoRenda();
        }
        
        aplicacao.calcularRendaLiquida();
        aplicacoes.add(aplicacao);
        aplicacao = new Aplicacao();
        
        Util.info("Sucesso");
    }
}
