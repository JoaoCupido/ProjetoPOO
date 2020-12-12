/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

/**
 *
 * @author jcupi
 */
public class Paciente extends Pessoa{
    private int anonascimento;
    private boolean covid, hiv, ebola;
    
    //ConstrutorD
    public Paciente(int anonascimento){
        super();
        this.anonascimento = anonascimento;
    }
    //metodos
    //getters e setters
    public int getAnoNascimento()
    {
        return anonascimento;
    }
    public void setAnoNascimento(int anonascimento)
    {
        this.anonascimento=anonascimento;
    }
    //toString
    @Override
    public String toString()
    {
        String info;
        info = "" ;
        return info;
    }
    //equals
}