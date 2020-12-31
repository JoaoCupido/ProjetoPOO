/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.HashMap;
/**
 *
 * @author jcupi
 */
public class Hospital {
    //variaveis de instancia
    private int numobitos,casospositivos, totalpacientestestados, anoscarreiraminimo;
    private double raciopacientespositivos;
    
    private HashMap<String,Pessoa> listaPessoas;
    private HashMap<String,Paciente> listaPacientes;
    
    //construtor
    public Hospital()
    {
        listaPessoas = new HashMap<>(0);
        listaPacientes = new HashMap<>(0);
    }
    //metodos
    public void addPessoa(Pessoa pessoa){
        listaPessoas.put(pessoa.getId(),pessoa);
    }
    public void addPaciente(Paciente paciente){
        listaPacientes.put(paciente.getId(),paciente);
    }
    public void removerPaciente(Paciente pacientearemover){ 
        listaPacientes.remove(pacientearemover.getId());
    }
    //getters e setters
    public int getAnosCarreiraMinimo(){
        return anoscarreiraminimo;
    }
    public void setAnosCarreiraMinimo(int anoscarreiraminimo){
        this.anoscarreiraminimo = anoscarreiraminimo;
    }
    public HashMap<String,Pessoa> getListaPessoas(){
        return listaPessoas;
    }
    public HashMap<String,Paciente> getListaPacientes(){
        return listaPacientes;
    }
    
    //toString
    //equals
}
