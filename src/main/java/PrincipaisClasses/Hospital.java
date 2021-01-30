/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author jcupi
 */
public class Hospital {
    //variaveis de instancia
    private int anoscarreiraminimo;
    
    private HashMap<String,Pessoa> listaPessoas;
    private HashMap<String,Paciente> listaPacientes;
    
    private RelatorioHospitalar relatorio;
    
    private ArrayList<Pessoa> pedidosAuxiliares;
    
    //construtor
    /**
     * Construtor de Hospital
     */
    public Hospital()
    {
        listaPessoas = new HashMap<>(0);
        listaPacientes = new HashMap<>(0);
        relatorio = new RelatorioHospitalar();
        pedidosAuxiliares = new ArrayList<>(0);
    }
    //metodos
    /**
     * addPessoa: adiciona pessoa à lista de pessoas do hospital
     * @param pessoa 
     */
    public void addPessoa(Pessoa pessoa){
        listaPessoas.put(pessoa.getId(),pessoa);
    }
    /**
     * addPaciente: adiciona paciente à lista de pacientes em espera do hospital
     * @param paciente 
     */
    public void addPaciente(Paciente paciente){
        listaPacientes.put(paciente.getId(),paciente);
    }
    /**
     * addPedido: adiciona pedido de enfermeiro-auxiliar na lista de pedidos de auxiliares
     * do hospital
     * @param auxiliar 
     */
    public void addPedido(Pessoa auxiliar){
        pedidosAuxiliares.add(auxiliar);
    }
    /**
     * removerPessoa: remove pessoa à lista de pessoas do hospital
     * @param pessoa 
     */
    public void removerPessoa(Pessoa pessoa){
        listaPessoas.remove(pessoa.getId());
    }
    /**
     * removerPaciente: remove pacientearemover à lista de pacientes em espera do hospital
     * @param pacientearemover 
     */
    public void removerPaciente(Paciente pacientearemover){ 
        listaPacientes.remove(pacientearemover.getId());
    }
    /**
     * removerPedido: remove pedido de enfermeiro-auxiliar na lista de pedidos de auxiliares
     * @param auxiliar 
     */
    public void removerPedido(Pessoa auxiliar){
        pedidosAuxiliares.remove(auxiliar);
    }
    //getters e setters
    /**
     * Getter da variável de instância anoscarreiraminimo
     * @return 
     */
    public int getAnosCarreiraMinimo(){
        return anoscarreiraminimo;
    }
    /**
     * Setter da variável de instância anoscarreiraminimo
     * @param anoscarreiraminimo 
     */
    public void setAnosCarreiraMinimo(int anoscarreiraminimo){
        this.anoscarreiraminimo = anoscarreiraminimo;
    }
    /**
     * Getter da variável de instância listaPessoas
     * @return 
     */
    public HashMap<String,Pessoa> getListaPessoas(){
        return listaPessoas;
    }
    /**
     * Setter da variável de instância listaPessoas
     * @return 
     */
    public HashMap<String,Paciente> getListaPacientes(){
        return listaPacientes;
    }
    /**
     * Getter da variável de instância relatorio
     * @return 
     */
    public RelatorioHospitalar getRelatorio() {
        return relatorio;
    }
    /**
     * Setter da variável de instância relatorio
     * @param relatorio 
     */
    public void setRelatorio(RelatorioHospitalar relatorio) {
        this.relatorio = relatorio;
    }
    /**
     * Getter da variável de instância pedidosAuxiliares
     * @return 
     */
    public ArrayList<Pessoa> getPedidos(){
        return pedidosAuxiliares;
    }
    /**
     * Setter da variável de instância pedidosAuxiliares
     * @param pedidosAuxiliares 
     */
    public void setPedidos(ArrayList<Pessoa> pedidosAuxiliares){
        this.pedidosAuxiliares = pedidosAuxiliares;
    }
    
    //toString
    //equals
}
