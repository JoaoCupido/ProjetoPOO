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
    private boolean covid, hiv, ebola;
    
    Random gerador = new Random();
    
    //ConstrutorD
    public Paciente(int anonascimento){
        super();
        this.anonascimento = anonascimento;
        covid = gerador.nextBoolean();
        hiv = gerador.nextBoolean();
        ebola = gerador.nextBoolean();
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
    public boolean getCovid(){
        return covid;
    }
    public void setCovid(boolean covid){
        this.covid = covid;
    }
    public boolean getHiv(){
        return hiv;
    }
    public void setHiv(boolean hiv){
        this.hiv = hiv;
    }
    public boolean getEbola(){
        return ebola;
    }
    public void setEbola(boolean ebola){
        this.ebola = ebola;
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
}