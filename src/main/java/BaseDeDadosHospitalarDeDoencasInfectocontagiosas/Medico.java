/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.ArrayList;
/**
 *
 * @author Utilizador
 */
public class Medico extends Pessoa{
    //variaveis de instancia
    private Paciente[] listaPacientesAlta = {null, null, null};
    private ArrayList<EnfermeiroAuxiliar> auxiliaresAcompanhados;
    private ArrayList<EnfermeiroEspecialista> especialistasAcompanhados;
    //construtor
    public Medico()
    {
        super();
        auxiliaresAcompanhados = new ArrayList<EnfermeiroAuxiliar>(1);
        especialistasAcompanhados = new ArrayList<EnfermeiroEspecialista>(1);
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
    
    public void atualizarEnfermeirosAcompanhados(Hospital hospital){
        boolean enfermeirounico = true;
        for(int i = 0; i < hospital.getListaPessoas().size(); i++){
            switch(hospital.getListaPessoas().get(i).getClass().getSimpleName()){
                case "EnfermeiroAuxiliar":
                    for(int j = 0; j < auxiliaresAcompanhados.size(); j++){
                        if(((EnfermeiroAuxiliar)hospital.getListaPessoas().get(i)).equals(auxiliaresAcompanhados.get(j))){
                            enfermeirounico = false;
                        }
                    }
                    if(enfermeirounico && ((EnfermeiroAuxiliar)hospital.getListaPessoas().get(i)).getMedicoAcompanhado().equals(this)){
                        auxiliaresAcompanhados.add((EnfermeiroAuxiliar)hospital.getListaPessoas().get(i));
                    }
                    break;
                case "EnfermeiroEspecialista":
                    for(int j = 0; j < especialistasAcompanhados.size(); j++){
                        if(((EnfermeiroEspecialista)hospital.getListaPessoas().get(i)).equals(especialistasAcompanhados.get(j))){
                            enfermeirounico = false;
                        }
                    }
                    if(enfermeirounico && ((EnfermeiroEspecialista)hospital.getListaPessoas().get(i)).getMedicoAcompanhado().equals(this)){
                        especialistasAcompanhados.add((EnfermeiroEspecialista)hospital.getListaPessoas().get(i));
                    }
                    break;
                default:
                    break;
            }
        }
    }
    //getters e setters
    public Paciente[] getlistaPacientesAlta(){
        return listaPacientesAlta;
    }
    public ArrayList<EnfermeiroAuxiliar> getAuxiliaresAcompanhados(){
        return auxiliaresAcompanhados;
    }
    public ArrayList<EnfermeiroEspecialista> getEspecialistasAcompanhados(){
        return especialistasAcompanhados;
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
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Medico med = (Medico) obj;
        return getId().equals(med.getId());
    }
}
