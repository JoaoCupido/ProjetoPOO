package Interface;
import PrincipaisClasses.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jcupi
 */
public interface RelacaoMedicoEnfermeiro {
    //metodos
    /**
     * Adiciona um paciente na agenda de um enfermeiro acompanhado
     * @param hospital
     * @param paciente 
     */
    public void addPacienteAgenda(Hospital hospital, Paciente paciente);
    /**
     * Remove um paciente da agenda de um enfermeiro acompanhado
     * @param paciente 
     */
    public void removePacienteAgenda(Paciente paciente);
    /**
     * Retorna true se a agenda do enfermeiro acompanhado está vazio
     * Retorna false caso contrário
     * @return 
     */
    public boolean isEmptyPacienteAgenda();
    /**
     * Retorna true se a agenda do enfermeiro acompanhado está cheio
     * Retorna false caso contrário
     * @return 
     */
    public boolean isFullPacienteAgenda();
    //getters e setters
    /**
     * Getter do medicoacompanhado de um enfermeiro acompanhado
     * @return 
     */
    public Medico getMedicoAcompanhado();
    /**
     * Setter do medicoacompanhado de um enfermeiro acompanhado
     * @param medico 
     */
    public void setMedicoAcompanhado(Medico medico);
    /**
     * Getter da agenda de um enfermeiro acompanhado
     * @return 
     */
    public Paciente[] getAgenda();
}
