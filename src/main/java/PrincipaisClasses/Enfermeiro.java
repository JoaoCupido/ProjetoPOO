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
    /**
     * Construtor de Enfermeiro
     * @param nome
     * @param anoscarreira 
     */
    public Enfermeiro(String nome, int anoscarreira)
    {
        super();
        this.nome = nome;
        this.anoscarreira = anoscarreira;
    }
    
    //metodos
    
    //getters e setters
    /**
     * Getter da variável de instância nome
     * @return 
     */
    public String getNome(){
        return nome;
    }
    /**
     * Getter da variável de instância anoscarreira
     * @return 
     */
    public int getAnosCarreira(){
        return anoscarreira;
    }
    /**
     * Setter da variável de instância nome
     * @param nome 
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    /**
     * Setter da variável de instância anoscarreira
     * @param anoscarreira 
     */
    public void setAnosCarreira(int anoscarreira){
        this.anoscarreira = anoscarreira;
    }
    //toString
    //equals
}
