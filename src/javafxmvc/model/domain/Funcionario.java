package javafxmvc.model.domain;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private int cdFuncionario;
    private String nome;
    private String cpf;
    private String telefone;

    public Funcionario(){
    }
    
    public Funcionario(int cdFuncionario, String nome, String cpf) {
        this.cdFuncionario = cdFuncionario;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getCdFuncionario() {
        return cdFuncionario;
    }

    public void setCdFuncionario(int cdFuncionario) {
        this.cdFuncionario = cdFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
