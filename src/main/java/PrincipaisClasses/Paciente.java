/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;
import java.util.Random;
/**
 *
 * @author jcupi
 */
public class Paciente extends Pessoa{
    private int anonascimento;
    private Doenca doenca;
    
    Random gerador = new Random();
    
    //Construtor
    /**
     * Construtor de Paciente
     * @param anonascimento 
     */
    public Paciente(int anonascimento){
        super();
        this.anonascimento = anonascimento;
        doenca = new Doenca();
    }
    //metodos
    //getters e setters
    /**
     * Getter da variável de instância anonascimento
     * @return 
     */
    public int getAnoNascimento()
    {
        return anonascimento;
    }
    /**
     * Setter da variável de instância anonascimento
     * @param anonascimento 
     */
    public void setAnoNascimento(int anonascimento)
    {
        this.anonascimento=anonascimento;
    }
    /**
     * Getter da variável de instância doenca
     * @return 
     */
    public Doenca getDoenca(){
        return doenca;
    }
    /**
     * Setter da variável de instância doenca
     * @param doenca 
     */
    public void setDoenca(Doenca doenca){
        this.doenca = doenca;
    }
    //toString
    /**
     * toString: texto do paciente
     * @return 
     */
    @Override
    public String toString()
    {
        String info;
        info = "PACIENTE: " + super.getId() + "\n";
        info += "ANO NASCIMENTO: " + anonascimento + "\n";
        return info;
    }
    //equals
    /**
     * equals: verificar se o paciente é igual ao this
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Paciente pac = (Paciente) obj;
        return getId().equals(pac.getId());
    }
}