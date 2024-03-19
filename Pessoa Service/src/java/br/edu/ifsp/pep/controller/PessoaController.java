package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import br.edu.ifsp.pep.service.PessoaService;
import br.edu.ifsp.pep.util.Util;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;




/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class PessoaController {
    
    @EJB
    private PessoaService pessoaService;
    
    private Pessoa pessoa = new Pessoa();
    
    public void login() {
        System.out.println("Método login do controller");
        Pessoa pessoaRetornada = pessoaService.login(pessoa.getLogin(), pessoa.getSenha());
        if(pessoaRetornada == null) {
            Util.error("Login e/ou Senha inválidos");
        } else {
            Util.info("Seja bem-vindo " + pessoaRetornada.getNome() + "!");
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
