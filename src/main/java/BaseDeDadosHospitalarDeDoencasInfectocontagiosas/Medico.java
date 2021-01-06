/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
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
    public Medico()
    {
        super();
        auxiliaresAcompanhados = new HashMap<>(0);
        especialistasAcompanhados = new HashMap<>(0);
    }
    
    //metodos
    public void addPacienteAlta(Paciente paciente){
        for(int i = 0; i < listaPacientesAlta.length; i++) {
            if(listaPacientesAlta[i] == null){
                listaPacientesAlta[i] = paciente;
                break;
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
    public boolean isEmptyPacienteAlta(){
        return (listaPacientesAlta[0]==null && listaPacientesAlta[1]==null && listaPacientesAlta[2]==null);
    }
    public boolean isFullPacienteAlta(){
        return (listaPacientesAlta[0]!=null && listaPacientesAlta[1]!=null && listaPacientesAlta[2]!=null);
    }
    
    public void atualizarEnfermeirosAcompanhados(Hospital hospital){ 
        boolean enfermeirounico = true;
        for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()){
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
    public Paciente[] getlistaPacientesAlta(){
        return listaPacientesAlta;
    }
    public HashMap<String,EnfermeiroAuxiliar> getAuxiliaresAcompanhados(){
        return auxiliaresAcompanhados;
    }
    public HashMap<String,EnfermeiroEspecialista> getEspecialistasAcompanhados(){
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
