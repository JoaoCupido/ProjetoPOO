/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;
import java.util.Arrays;
import java.util.HashMap;
/**
 *
 * @author Utilizador
 */
public class Medico extends Pessoa{
    //variaveis de instancia
    private Paciente[] listaPacientesAlta = {null, null, null};
    private HashMap<String,EnfermeiroAuxiliar> auxiliaresAcompanhados;
    private HashMap<String,EnfermeiroEspecialista> especialistasAcompanhados;
    //construtor
    /**
     * Construtor de Medico
     */
    public Medico()
    {
        super();
        auxiliaresAcompanhados = new HashMap<>(0);
        especialistasAcompanhados = new HashMap<>(0);
    }
    //metodos
    /**
     * addPacienteAlta: adicionar paciente à lista de pacientes a aguardar alta do médico
     * @param paciente 
     */
    public void addPacienteAlta(Paciente paciente){
        for(int i = 0; i < listaPacientesAlta.length; i++) {
            if(listaPacientesAlta[i] == null){
                listaPacientesAlta[i] = paciente;
                break;
            }
        }
    }
    /**
     * removePacienteAlta: remover paciente à lista de pacientes a aguardar alta do médico
     * @param paciente 
     */
    public void removePacienteAlta(Paciente paciente){
        for(int i = 0; i < listaPacientesAlta.length; i++){
            if(paciente.equals(listaPacientesAlta[i])){
                listaPacientesAlta[i] = null;
                break;
            }
        }
    }
    /**
     * isEmptyPacienteAlta: Retorna true se lista de pacientes a aguardar alta está vazia.
     * Caso contrário, retorna false.
     * @return 
     */
    public boolean isEmptyPacienteAlta(){
        return (listaPacientesAlta[0]==null && listaPacientesAlta[1]==null && listaPacientesAlta[2]==null);
    }
    /**
     * isEmptyPacienteAlta: Retorna true se lista de pacientes a aguardar alta está cheia.
     * Caso contrário, retorna false.
     * @return 
     */
    public boolean isFullPacienteAlta(){
        return (listaPacientesAlta[0]!=null && listaPacientesAlta[1]!=null && listaPacientesAlta[2]!=null);
    }
    /**
     * containsPacienteInPacienteAlta: Retorna true se o paciente está na lista de pacientes a
     * aguardar alta do médico. Caso contrário, retorna false.
     * @param paciente
     * @return 
     */
    public boolean containsPacienteInPacienteAlta(Paciente paciente){
        return (paciente.equals(listaPacientesAlta[0]) || paciente.equals(listaPacientesAlta[1]) || paciente.equals(listaPacientesAlta[2]));
    }
    /**
     * atualizarEnfermeirosAcompanhados: Atualiza a lista de enfermeiros auxiliares e de enfermeiros
     * especialistas do médico acompanhado
     * @param hospital 
     */
    public void atualizarEnfermeirosAcompanhados(Hospital hospital){ 
        for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()){
            boolean enfermeirounico = true;
            switch(pessoaencontrar.getClass().getSimpleName()){
                case "EnfermeiroAuxiliar":
                    for(EnfermeiroAuxiliar ea : auxiliaresAcompanhados.values()){
                        if(((EnfermeiroAuxiliar)pessoaencontrar).equals(ea)){
                            enfermeirounico = false;
                        }
                    }
                    if(enfermeirounico && this.equals(((EnfermeiroAuxiliar)pessoaencontrar).getMedicoAcompanhado())){
                        auxiliaresAcompanhados.put(pessoaencontrar.getId(),(EnfermeiroAuxiliar)pessoaencontrar);
                    }
                    break;
                case "EnfermeiroEspecialista":
                    for(EnfermeiroEspecialista ee : especialistasAcompanhados.values()){
                        if(((EnfermeiroEspecialista)pessoaencontrar).equals(ee)){
                            enfermeirounico = false;
                        }
                    }
                    if(enfermeirounico && this.equals(((EnfermeiroEspecialista)pessoaencontrar).getMedicoAcompanhado())){
                        especialistasAcompanhados.put(pessoaencontrar.getId(),(EnfermeiroEspecialista)pessoaencontrar);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    //getters e setters
    /**
     * Getter da variável de instância listaPacientesAlta
     * @return 
     */
    public Paciente[] getlistaPacientesAlta(){
        return listaPacientesAlta;
    }
    /**
     * Getter da variável de instância auxiliaresAcompanhados
     * @return 
     */
    public HashMap<String,EnfermeiroAuxiliar> getAuxiliaresAcompanhados(){
        return auxiliaresAcompanhados;
    }
    /**
     * Getter da variável de instância especialistasAcompanhados
     * @return 
     */
    public HashMap<String,EnfermeiroEspecialista> getEspecialistasAcompanhados(){
        return especialistasAcompanhados;
    }
    //toString
    /**
     * toString: texto do médico
     * @return 
     */
    @Override
    public String toString()
    {
        String info;
        info = "MÉDICO: " + super.getId() + "\n";
        info += "LISTA DE PACIENTES A AGUARDAR ALTA DESTE MÉDICO: " + Arrays.toString(listaPacientesAlta) + "\n";
        info += "LISTA DE ENFERMEIROS AUXILIARES ACOMPANHADOS POR ESTE MÉDICO: " + auxiliaresAcompanhados.keySet() + "\n";
        info += "LISTA DE ENFERMEIROS ESPECIALISTAS ACOMPANHADOS POR ESTE MÉDICO: " + especialistasAcompanhados.keySet() + "\n";
        return info;
    }
    //equals
    /**
     * equals: verificar se o médico é igual ao this
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Medico med = (Medico) obj;
        return getId().equals(med.getId());
    }
}
