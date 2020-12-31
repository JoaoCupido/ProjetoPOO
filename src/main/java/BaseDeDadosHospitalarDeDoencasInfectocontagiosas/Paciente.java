/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.Random;
/**
 *
 * @author jcupi
 */
public class Paciente extends Pessoa{
    private int anonascimento;
    private Doenca doenca;
    
    Random gerador = new Random();
    
    //ConstrutorD
    public Paciente(int anonascimento){
        super();
        this.anonascimento = anonascimento;
        doenca = new Doenca();
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
    public Doenca getDoenca(){
        return doenca;
    }
    public void setDoenca(Doenca doenca){
        this.doenca = doenca;
    }
    //toString
    @Override
    public String toString()
    {
        String info;
        info = "PACIENTE: " + super.getId() + "\n";
        info += "ANO NASCIMENTO: " + anonascimento + "\n";
        return info;
    }
    //equals
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Paciente pac = (Paciente) obj;
        return getId().equals(pac.getId());
    }
}