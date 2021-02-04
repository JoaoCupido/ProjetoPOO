/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;

import Interface.RelacaoMedicoEnfermeiro;

/**
 *
 * @author jcupi
 */
public class EnfermeiroEspecialista extends Enfermeiro implements RelacaoMedicoEnfermeiro{
    //variaveis de instancia
    private Medico medicoacompanhado;
    private Paciente[] agenda = {null, null, null};
    //construtor
    /**
     * Construtor de EnfermeiroEspecialista
     * @param nome
     * @param anoscarreira 
     */
    public EnfermeiroEspecialista(String nome, int anoscarreira)
    {
        super(nome, anoscarreira);
        medicoacompanhado = null;
    }
    //metodos
    /**
     * addPacienteAgenda: adicionar um paciente na agenda do enfermeiro-especialista
     * @param hospital
     * @param paciente 
     */
    public void addPacienteAgenda(Hospital hospital, Paciente paciente){
        for(int i = 0; i < agenda.length; i++) {
            if(agenda[i] == null){
                hospital.removerPaciente(paciente);
                agenda[i] = paciente;
                break;
            }
        }
    }
    /**
     * removePacienteAgenda: remover um paciente na agenda do enfermeiro-especialista
     * @param paciente 
     */
    public void removePacienteAgenda(Paciente paciente){
        for(int i = 0; i < agenda.length; i++){
            if(paciente.equals(agenda[i])){
                agenda[i] = null;
                break;
            }
        }
    }
    /**
     * agendaPacientes: retorna um String de texto da agenda de pacientes
     * do enfermeiro-especialista
     * @return 
     */
    public String agendaPacientes(){
        String texto;
        texto = "AGENDA DESTE ENFERMEIRO: {";
        if(agenda[0]!=null){
            texto += agenda[0].getId() + ",";
        }
        else{
            texto += "null,";
        }
        if(agenda[1]!=null){
            texto += agenda[1].getId() + ",";
        }
        else{
            texto += "null,";
        }
        if(agenda[2]!=null){
            texto += agenda[2].getId() + "}";
        }
        else{
            texto += "null}";
        }
        texto += "\n";
        return texto;
    }
    /**
     * Retorna true se a agenda do enfermeiro acompanhado está vazio
     * Retorna false caso contrário
     * @return 
     */
    public boolean isEmptyPacienteAgenda(){
        return (agenda[0]==null && agenda[1]==null && agenda[2]==null);
    }
    /**
     * Retorna true se a agenda do enfermeiro acompanhado está cheio
     * Retorna false caso contrário
     * @return 
     */
    public boolean isFullPacienteAgenda(){
        return (agenda[0]!=null && agenda[1]!=null && agenda[2]!=null);
    }
    //getters e setters
    /**
     * Getter da variável de instância medicoacompanhado
     * @return 
     */
    public Medico getMedicoAcompanhado(){
        return medicoacompanhado;
    }
    /**
     * Setter da variável de instância medicoacompanhado
     * @param medico 
     */
    public void setMedicoAcompanhado(Medico medico){
        medicoacompanhado = medico;
    }
    /**
     * Getter da variável de instância agenda
     * @return 
     */
    public Paciente[] getAgenda(){
        return agenda;
    }
    //toString
    /**
     * toString: texto do enfermeiro-auxiliar
     * @return 
     */
    @Override
    public String toString()
    {
        String info;
        info = "ENFERMEIRO: " + getClass().getSimpleName() + "\n";
        info += "NOME: " + getNome() + "\n";
        info += "ID: " + getId() + "\n";
        info += "ANOS DE EXPERIÊNCIA: " + getAnosCarreira() + "\n";
        if(medicoacompanhado !=null){
            info += "MÉDICO ALOCADO: " + medicoacompanhado.getId() + "\n";
        }
        else{
            info += "MÉDICO ALOCADO: " + medicoacompanhado + "\n";
        }
        info += agendaPacientes();
        return info;
    }
    //equals
    /**
     * equals: verificar se o enfermeiro auxiliar é igual ao this
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        EnfermeiroEspecialista ee = (EnfermeiroEspecialista) obj;
        return getId().equals(ee.getId());
    }
}
