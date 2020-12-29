/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

/**
 *
 * @author Utilizador
 */
public class Medico extends Pessoa{
    //variaveis de instancia
    private Paciente[] listaPacientesAlta = {null, null, null};
    //construtor
    public Medico()
    {
        super();
    }
    
    //metodos
    public void addPacienteAlta(Paciente paciente, Enfermeiro enfermeiro){
        if(listaPacientesAlta[0] != null && listaPacientesAlta[1] != null && listaPacientesAlta[2] != null){
            System.out.println("ERRO! O médico " + this.getId() + " já tem o máximo de 3 pacientes.");
        }
        else{
            for(int i = 0; i < listaPacientesAlta.length; i++) {
                if(listaPacientesAlta[i] == null){
                    if(enfermeiro.getClass().getSimpleName().equals("EnfermeiroAuxiliar") && ((EnfermeiroAuxiliar) enfermeiro).getMedicoAcompanhado().getId().equals(this.getId())){
                        ((EnfermeiroAuxiliar) enfermeiro).removePacienteAgenda(paciente);
                        listaPacientesAlta[i] = paciente;
                        break;
                    }
                    else if(enfermeiro.getClass().getSimpleName().equals("EnfermeiroEspecialista") && ((EnfermeiroEspecialista) enfermeiro).getMedicoAcompanhado().getId().equals(this.getId())){
                        ((EnfermeiroEspecialista) enfermeiro).removePacienteAgenda(paciente);
                        listaPacientesAlta[i] = paciente;
                        break;
                    }
                }
            }
        }
    }
    public void removePacienteAlta(Paciente paciente){
        for(int i = 0; i < listaPacientesAlta.length; i++){
            if(listaPacientesAlta[i].equals(paciente)){
                listaPacientesAlta[i] = null;
                break;
            }
        }
    }
    public boolean vazioPacienteAlta(){
        return (listaPacientesAlta[0]==null && listaPacientesAlta[1]==null && listaPacientesAlta[2]==null);
    }
    //getters e setters
    public Paciente[] getlistaPacientesAlta(){
        return listaPacientesAlta;
    }
    //toString
    @Override
    public String toString()
    {
        String info;
        info = "MÉDICO: " + super.getId() + "\n";
        return info;
    }
    //equals
}
