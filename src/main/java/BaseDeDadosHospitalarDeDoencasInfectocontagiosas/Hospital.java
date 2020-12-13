/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.ArrayList;
/**
 *
 * @author jcupi
 */
public class Hospital {
    //variaveis de instancia
    private int numobitos,casospositivos, totalpacientestestados, anoscarreiraminimo;
    private double raciopacientespositivos;
    
    ArrayList<Pessoa> listaPessoas;
    //construtor
    public Hospital()
    {
        listaPessoas = new ArrayList<Pessoa>();
    }
    //metodos
    //getters e setters
    public int getAnosCarreiraMinimo(){
        return anoscarreiraminimo;
    }
    public void setAnosCarreiraMinimo(int anoscarreiraminimo){
        this.anoscarreiraminimo = anoscarreiraminimo;
    }
    //toString
    //equals
}
