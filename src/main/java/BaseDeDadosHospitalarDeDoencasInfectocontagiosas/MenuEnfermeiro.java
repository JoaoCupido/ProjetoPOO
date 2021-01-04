/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

import java.util.Map;
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
                    listarEnfermeiros(hospital);
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Listar Pacientes a aguardar Curativo...\n");
                    listarPacientesCurativo(hospital);
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
    
    public void listarEnfermeiros(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do médico a selecionar: ");
        String medicoid = scanner.next();
        if(!hospital.getListaPessoas().containsKey(medicoid)){
            throw new ArrayIndexOutOfBoundsException("O ID a procurar não existe na ListaPessoas.");
        }
        else{
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(medicoid) && elementonalista.getValue().getClass().getSimpleName().equals("Medico")){
                    System.out.println("LISTA DE ENFERMEIROS ACOMPANHADOS DO MÉDICO " + elementonalista.getValue().getId() + " :");
                        for(EnfermeiroAuxiliar ea : ((Medico)elementonalista.getValue()).getAuxiliaresAcompanhados().values()){
                            System.out.println(ea);
                        }
                        for(EnfermeiroEspecialista ee : ((Medico)elementonalista.getValue()).getEspecialistasAcompanhados().values()){
                            System.out.println(ee);
                        }
                    break;
                    }
                else if(elementonalista.getKey().equals(medicoid) && !(elementonalista.getValue().getClass().getSimpleName().equals("Medico"))){
                    throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um médico.");
                    //break;
                }
            }
        }
    }
    
    public void listarPacientesCurativo(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do enfermeiro auxiliar ou especialista a selecionar: ");
        String enfermeiroid = scanner.next();
        if(!hospital.getListaPessoas().containsKey(enfermeiroid)){
            throw new ArrayIndexOutOfBoundsException("O ID a procurar não existe na ListaPessoas.");
        }
        else {
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(enfermeiroid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                    System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO AUXILIAR " + elementonalista.getValue().getId() + " DE NOME " + ((EnfermeiroAuxiliar) elementonalista.getValue()).getNome() + " :");
                    EnfermeiroAuxiliar auxiliar = (EnfermeiroAuxiliar) elementonalista.getValue();
                    for (Paciente paciente : auxiliar.getAgenda()) {
                        System.out.println(paciente);
                    }
                    break;
                }
                else if(elementonalista.getKey().equals(enfermeiroid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                    System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO ESPECIALISTA " + elementonalista.getValue().getId() + " DE NOME " + ((EnfermeiroEspecialista) elementonalista.getValue()).getNome() + " :");
                    EnfermeiroEspecialista especialista = (EnfermeiroEspecialista) elementonalista.getValue();
                    for (Paciente paciente : especialista.getAgenda()) {
                        System.out.println(paciente);
                    }
                    break;
                }
                else if(elementonalista.getKey().equals(enfermeiroid) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroAuxiliar"))){
                    throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence nem a um enfermeiro auxiliar nem a um enfermeiro especialista.");
                    //break;
                }
            }
        }
    }
    
    public void atribuirEnfermeiroEspecialista(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do enfermeiro chefe a selecionar: ");
        String chefeid = scanner.next();
        if(!hospital.getListaPessoas().containsKey(chefeid)){
            throw new ArrayIndexOutOfBoundsException("O ID do chefe a procurar não existe na ListaPessoas.");
        }
        else {
            for(Map.Entry<String,Pessoa> elementonalista : hospital.getListaPessoas().entrySet()){
                if(elementonalista.getKey().equals(chefeid) && !(elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe"))){
                    throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um enfermeiro chefe.");
                }
                else if(elementonalista.getKey().equals(chefeid) && elementonalista.getValue().getClass().getSimpleName().equals("EnfermeiroChefe")){
                    System.out.println("Insira o ID do enfermeiro-especialista a ser atribuído: ");
                    String enfermeiroid = scanner.next();
                    System.out.println("Insira o ID do médico a receber o enfermeiro-especialista: ");
                    String medicoid = scanner.next();
                    if(!hospital.getListaPessoas().containsKey(enfermeiroid)){
                        throw new ArrayIndexOutOfBoundsException("O ID do enfermeiro-especialista a ser atribuído não existe na ListaPessoas.");
                    }
                    else if(!hospital.getListaPessoas().containsKey(medicoid)){
                        throw new ArrayIndexOutOfBoundsException("O ID do médico a receber o enfermeiro-especialista não existe na ListaPessoas.");
                    }
                    else{
                        for(Map.Entry<String,Pessoa> especialistanalista : hospital.getListaPessoas().entrySet()){
                            if(especialistanalista.getKey().equals(enfermeiroid) && !(especialistanalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista"))){
                                throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um enfermeiro-especialista.");
                            }
                            else if(especialistanalista.getKey().equals(enfermeiroid) && especialistanalista.getValue().getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                                for(Map.Entry<String,Pessoa> mediconalista : hospital.getListaPessoas().entrySet()){
                                    if(mediconalista.getKey().equals(medicoid) && !(mediconalista.getValue().getClass().getSimpleName().equals("Medico"))){
                                        throw new ArrayIndexOutOfBoundsException("O ID foi encontrado, mas não pertence a um médico.");
                                    }
                                    else if(mediconalista.getKey().equals(medicoid) && mediconalista.getValue().getClass().getSimpleName().equals("Medico")){
                                        ((EnfermeiroEspecialista)especialistanalista).setMedicoAcompanhado((Medico)mediconalista.getValue());
                                        ((Medico)mediconalista.getValue()).atualizarEnfermeirosAcompanhados(hospital);
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void aplicarCurativo(Hospital hospital)
    {
        
    }
    //getters e setters
    //toString
    //equals
}
