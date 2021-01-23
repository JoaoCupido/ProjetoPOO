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
    public EnfermeiroEspecialista(String nome, int anoscarreira)
    {
        super(nome, anoscarreira);
        medicoacompanhado = null;
    }
    //metodos
    public void addPacienteAgenda(Hospital hospital, Paciente paciente){
        for(int i = 0; i < agenda.length; i++) {
            if(agenda[i] == null){
                hospital.removerPaciente(paciente);
                agenda[i] = paciente;
                break;
            }
        }
    }
    public void removePacienteAgenda(Paciente paciente){
        for(int i = 0; i < agenda.length; i++){
            if(paciente.equals(agenda[i])){
                agenda[i] = null;
                break;
            }
        }
    }
    public boolean isEmptyPacienteAgenda(){
        return (agenda[0]==null && agenda[1]==null && agenda[2]==null);
    }
    public boolean isFullPacienteAgenda(){
        return (agenda[0]!=null && agenda[1]!=null && agenda[2]!=null);
    }
    //getters e setters
    public Medico getMedicoAcompanhado(){
        return medicoacompanhado;
    }
    public void setMedicoAcompanhado(Medico medico){
        medicoacompanhado = medico;
    }
    public Paciente[] getAgenda(){
        return agenda;
    }
    //toString
    @Override
    public String toString()
    {
        String info;
        info = "ENFERMEIRO: " + getClass().getSimpleName() + "\n";
        info += "NOME: " + getNome() + "\n";
        info += "ID: " + getId() + "\n";
        info += "ANOS DE EXPERIENCIA: " + getAnosCarreira() + "\n";
        info += "MEDICO ALOCADO: " + medicoacompanhado + "\n";
        return info;
    }
    //equals
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        EnfermeiroEspecialista ee = (EnfermeiroEspecialista) obj;
        return getId().equals(ee.getId());
    }
}
