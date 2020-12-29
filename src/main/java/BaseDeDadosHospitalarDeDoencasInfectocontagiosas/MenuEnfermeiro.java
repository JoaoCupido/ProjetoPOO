/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

import java.util.Scanner;

/**
 *
 * @author jcupi
 */
public class MenuEnfermeiro {
    //variaveis de instancia
    //construtor
    //metodos
     public void menuOpcoesEnfermeiro(Hospital hospital){
        int opcao;
        System.out.println("***SubMenu Enfermeiro***");
        System.out.println("1) Listar Enfermeiros de Médico");
        System.out.println("2) Listar Pacientes a aguardar Curativo");
        System.out.println("3) Atribuir Enfermeiro Especialista a Médico");
        System.out.println("4) Aplicar Curativo a Paciente");
        Scanner escolha = new Scanner(System.in);
        System.out.println("Digite uma opção. Digite nenhuma das opções apresentadas para sair do SubMenu Enfermeiro: ");
        opcao = escolha.nextInt();

        switch(opcao)
            {
                case 1:
                    System.out.println("\nEscolhido a opção Listar Enfermeiros de Médico...\n");
                    Scanner scannermedico = new Scanner(System.in);
                    System.out.println("Insira o ID do médico a selecionar: ");
                    String medicoid = scannermedico.next();
                    if(!isMedicoOnListaPessoas(hospital,medicoid)){
                        throw new ArrayIndexOutOfBoundsException("O médico a procurar não existe na ListaPessoas.");
                    }
                    else{
                        for(int i = 0; i < hospital.getListaPessoas().size(); i++){
                            if(hospital.getListaPessoas().get(i).getId().equals(medicoid) && hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("Medico")){
                                System.out.println("LISTA DE PACIENTES A AGUARDAR ALTA DO MÉDICO " + hospital.getListaPessoas().get(i).getId() + " :");
                                listarEnfermeiros(hospital, (Medico) hospital.getListaPessoas().get(i));
                                break;
                            }
                            else if(hospital.getListaPessoas().get(i).getId().equals(medicoid) && !(hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("Medico"))){
                                throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um médico.");
                                //break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Listar Pacientes a aguardar Curativo...\n");
                    Scanner scannerenfermeiro = new Scanner(System.in);
                    System.out.println("Insira o ID do enfermeiro auxiliar ou especialista a selecionar: ");
                    String enfermeiroid = scannerenfermeiro.next();
                    if(!isEnfermeiroAuxiliarOuEnfermeiroEspecialistaOnListaPessoas(hospital,enfermeiroid)){
                        throw new ArrayIndexOutOfBoundsException("O enfermeiro auxiliar ou especialista a procurar não existe na ListaPessoas.");
                    }
                    else {
                        for(int i = 0; i < hospital.getListaPessoas().size(); i++){
                            if(hospital.getListaPessoas().get(i).getId().equals(enfermeiroid) && hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                                System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO AUXILIAR " + hospital.getListaPessoas().get(i).getId() + " DE NOME " + ((EnfermeiroAuxiliar) hospital.getListaPessoas().get(i)).getNome() + " :");
                                listarPacientesCurativo((Enfermeiro) hospital.getListaPessoas().get(i));
                                break;
                            }
                            else if(hospital.getListaPessoas().get(i).getId().equals(enfermeiroid) && hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                                System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO ESPECIALISTA " + hospital.getListaPessoas().get(i).getId() + " DE NOME " + ((EnfermeiroEspecialista) hospital.getListaPessoas().get(i)).getNome() + " :");
                                listarPacientesCurativo((Enfermeiro) hospital.getListaPessoas().get(i));
                                break;
                            }
                            else if(hospital.getListaPessoas().get(i).getId().equals(enfermeiroid) && !(hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroEspecialista")) && !(hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroAuxiliar"))){
                                throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence nem a um enfermeiro auxiliar nem a um enfermeiro especialista.");
                                //break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nEscolhido a opção Atribuir Enfermeiro Especialista a Médico...\n");
                    atribuirEnfermeiroEspecialista(hospital);
                    break;
                case 4:
                    System.out.println("\nEscolhido a opção Aplicar Curativo a Paciente...\n");
                    aplicarCurativo(hospital);
                    break;
                default:
                    System.out.println("\nNão foi escolhido nenhuma das opções que foram apresentadas! Voltando para Menu...\n");
                    break;
        }
    }
    
    public void listarEnfermeiros(Hospital hospital, Medico medico)
    {
        for(int i = 0 ; i < hospital.getListaPessoas().size(); i++){
            if(hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroAuxiliar") && ((EnfermeiroAuxiliar) hospital.getListaPessoas().get(i)).getMedicoAcompanhado().equals(medico)){
                System.out.println((EnfermeiroAuxiliar) hospital.getListaPessoas().get(i));
            }
            else if(hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroEspecialista") && ((EnfermeiroEspecialista) hospital.getListaPessoas().get(i)).getMedicoAcompanhado().equals(medico)){
                System.out.println((EnfermeiroEspecialista) hospital.getListaPessoas().get(i));
            }
        }
    }
    
    public void listarPacientesCurativo(Enfermeiro enfermeiro)
    {
        if(enfermeiro.getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
            EnfermeiroAuxiliar auxiliar = (EnfermeiroAuxiliar) enfermeiro;
            for (Paciente paciente : auxiliar.getAgenda()) {
                System.out.println(paciente);
            }
        }
        else if(enfermeiro.getClass().getSimpleName().equals("EnfermeiroEspecialista")){
            EnfermeiroEspecialista especialista = (EnfermeiroEspecialista) enfermeiro;
            for (Paciente paciente : especialista.getAgenda()) {
                System.out.println(paciente);
            }
        }
    }
    
    public void atribuirEnfermeiroEspecialista(Hospital hospital)
    {
        
    }
    
    public void aplicarCurativo(Hospital hospital)
    {
        
    }
    
    public boolean isMedicoOnListaPessoas(Hospital hospital, String medicoid){
        boolean ismedico = false;
        for(int i = 0; i < hospital.getListaPessoas().size(); i++){
            if(hospital.getListaPessoas().get(i).getId().equals(medicoid) && hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("Medico")){
                ismedico = true;
                break;
            }
        }
        return ismedico;
    }
    
    public boolean isEnfermeiroAuxiliarOuEnfermeiroEspecialistaOnListaPessoas(Hospital hospital, String enfermeiroid){
        boolean foundenfermeiro = false;
        for(int i = 0; i < hospital.getListaPessoas().size(); i++){
            if((hospital.getListaPessoas().get(i).getId().equals(enfermeiroid) && hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroAuxiliar")) || (hospital.getListaPessoas().get(i).getId().equals(enfermeiroid) && hospital.getListaPessoas().get(i).getClass().getSimpleName().equals("EnfermeiroEspecialista"))){
                foundenfermeiro = true;
                break;
            }
        }
        return foundenfermeiro;
    }
    //getters e setters
    //toString
    //equals
}
