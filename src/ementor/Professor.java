/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor;

/**
 *
 * @author Vincenzo
 */
public class Professor extends Pessoa {
    private String data_admissao;
    private double salario_bruto;
    boolean CargoChefia, CargoCoordenador;
    
    public Professor() {
        super();
        this.data_admissao = "";
        this.salario_bruto = 0;
        this.CargoChefia = false;
        this.CargoCoordenador = false;
    }

    public Professor(String data_admissao, double salario_bruto, String nome, String data_nascimento, long CPF, String telefone, String rua, String bairro, String cidade, String estado, boolean cargoChefia, boolean cargoCoordenador) {
        super(nome, data_nascimento, telefone, rua, bairro, cidade, estado, CPF);
        this.data_admissao = data_admissao;
        this.salario_bruto = salario_bruto;
        this.CargoChefia = cargoChefia;
        this.CargoCoordenador = cargoCoordenador;
    }

    public boolean isCargoChefia() {
        return CargoChefia;
    }

    public void setCargoChefia(boolean CargoChefia) {
        this.CargoChefia = CargoChefia;
    }

    public boolean isCargoCoordenador() {
        return CargoCoordenador;
    }

    public void setCargoCoordenador(boolean CargoCoordenador) {
        this.CargoCoordenador = CargoCoordenador;
    }
    
    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public double getSalario_bruto() {
        return salario_bruto;
    }

    public void setSalario_bruto(double salario_bruto) {
        this.salario_bruto = salario_bruto;
    }
    
    public double salario_liquido(double salario_bruto) {
        double salario_liquido;
        if (salario_bruto > 5000) {
            salario_liquido = salario_bruto * 0.225;
        } else {
            salario_liquido = salario_bruto * 0.14;
        }
        return salario_liquido;
    }
}
