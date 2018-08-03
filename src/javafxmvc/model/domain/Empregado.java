package javafxmvc.model.domain;

import java.io.Serializable;

public class Empregado implements Serializable {

    private int cd_empregado;
    private String nome_empregado;
    private double salario;
    private Categoria funcao;

    public Empregado() {
    }

    public Empregado(int cd_empregado, String nome_empregado, double salario) {
        this.cd_empregado = cd_empregado;
        this.nome_empregado = nome_empregado;
        this.salario = salario;
    
    }

    public int getCd_empregado() {
        return cd_empregado;
    }

    public void setCd_empregado(int cd_empregado) {
        this.cd_empregado = cd_empregado;
    }

    public String getNome_empregado() {
        return nome_empregado;
    }

    public void setNome_empregado(String nome_empregado) {
        this.nome_empregado = nome_empregado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Categoria getFuncao() {
        return funcao;
    }

    public void setFuncao(Categoria funcao) {
        this.funcao = funcao;
    }

    

    @Override
    public String toString() {
        return this.nome_empregado;
    }
    
}
