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
    public void addPacienteAlta(Paciente paciente){
        if(listaPacientesAlta[0] != null && listaPacientesAlta[1] != null && listaPacientesAlta[2] != null){
            System.out.println("ERRO! O médico " + this.getId() + " já tem o máximo de 3 pacientes.");
        }
        else{
            for(int i = 0; i < listaPacientesAlta.length; i++) {
                if(listaPacientesAlta[i] == null){
                    //remover paciente da agenda de enfermeiros
                    listaPacientesAlta[i] = paciente;
                    break;
                }
            }
        }
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
