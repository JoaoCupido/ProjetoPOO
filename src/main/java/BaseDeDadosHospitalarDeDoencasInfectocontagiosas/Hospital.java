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
    
    private ArrayList<Pessoa> listaPessoas;
    private ArrayList<Paciente> listaPacientes;
    
    //construtor
    public Hospital()
    {
        listaPessoas = new ArrayList<Pessoa>();
        listaPacientes = new ArrayList<Paciente>();
    }
    //metodos
    public void addPessoa(Pessoa pessoa){
        listaPessoas.add(pessoa);
    }
    public void addPaciente(Paciente paciente){
        listaPacientes.add(paciente);
    }
    public void removerPaciente(Paciente pacientearemover){
        for(int i = 0; i < listaPacientes.size(); i++){
            if(listaPacientes.get(i).equals(pacientearemover)){
                listaPacientes.remove(i);
                break;
            }
        }
    }
    //getters e setters
    public int getAnosCarreiraMinimo(){
        return anoscarreiraminimo;
    }
    public void setAnosCarreiraMinimo(int anoscarreiraminimo){
        this.anoscarreiraminimo = anoscarreiraminimo;
    }
    public ArrayList<Pessoa> getListaPessoas(){
        return listaPessoas;
    }
    public ArrayList<Paciente> getListaPacientes(){
        return listaPacientes;
    }
    
    //toString
    //equals
}
