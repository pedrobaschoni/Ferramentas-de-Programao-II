package br.edu.ifsp.pep.service;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PessoaService {
    private List<Pessoa> pessoas;

    public PessoaService() {
        this.carregarPessoas();
    }
    
    public Pessoa login(String login, String senha) {
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }
    
    private void carregarPessoas() {
        this.pessoas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            this.pessoas.add(new Pessoa(i, "Pessoa " + i, "pessoa" + i, "ifsp"));
        }
    }
}
