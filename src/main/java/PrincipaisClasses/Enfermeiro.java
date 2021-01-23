/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;

/**
 *
 * @author jcupi
 */
public abstract class Enfermeiro extends Pessoa{
    //variaveis de instancia
    private String nome;
    private int anoscarreira;
    //construtor
    public Enfermeiro(String nome, int anoscarreira)
    {
        super();
        this.nome = nome;
        this.anoscarreira = anoscarreira;
    }
    
    //metodos
    
    //getters e setters
    public String getNome(){
        return nome;
    }
    public int getAnosCarreira(){
        return anoscarreira;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAnosCarreira(int anoscarreira){
        this.anoscarreira = anoscarreira;
    }
    //toString
    //equals
}
