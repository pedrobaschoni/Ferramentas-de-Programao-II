package br.edu.ifsp.pep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tarefa")
@NamedQueries(
        @NamedQuery(name = "Tarefa.findAll", query="SELECT t FROM Tarefa t")
)
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;
    @Column(name = "data_modificacao", nullable = false)
    private LocalDate dataModificacao;
    @Column(name = "status", length = 40, nullable = false)
    private String status;

    public Tarefa() {
    }

    public Tarefa(int codigo, String descricao, LocalDate dataCadastro, LocalDate dataModificacao, String status) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.dataModificacao = dataModificacao;
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        return this.codigo == other.codigo;
    }
 
}
