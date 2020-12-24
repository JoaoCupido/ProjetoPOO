package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

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
    public void addPacienteAgenda(Hospital hospital, Paciente paciente);
    public void removePacienteAgenda(Paciente paciente);
    //getters e setters
    public Medico getMedicoAcompanhado();
    public void setMedicoAcompanhado(Medico medico);
}
