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
                    if(!hospital.getListaPessoas().containsKey(medicoid)){
                        throw new ArrayIndexOutOfBoundsException("O ID a procurar não existe na ListaPessoas.");
                    }
                    else{
                        for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()){
                            if(pessoaencontrar.getId().equals(medicoid) && pessoaencontrar.getClass().getSimpleName().equals("Medico")){
                                System.out.println("LISTA DE ENFERMEIROS ACOMPANHADOS DO MÉDICO " + pessoaencontrar.getId() + " :");
                                listarEnfermeiros((Medico) pessoaencontrar);
                                break;
                            }
                            else if(pessoaencontrar.getId().equals(medicoid) && !(pessoaencontrar.getClass().getSimpleName().equals("Medico"))){
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
                    if(!hospital.getListaPessoas().containsKey(enfermeiroid)){
                        throw new ArrayIndexOutOfBoundsException("O ID a procurar não existe na ListaPessoas.");
                    }
                    else {
                        for(Pessoa pessoaencontrar : hospital.getListaPessoas().values()){
                            if(pessoaencontrar.getId().equals(enfermeiroid) && pessoaencontrar.getClass().getSimpleName().equals("EnfermeiroAuxiliar")){
                                System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO AUXILIAR " + pessoaencontrar.getId() + " DE NOME " + ((EnfermeiroAuxiliar) pessoaencontrar).getNome() + " :");
                                listarPacientesCurativo((Enfermeiro) pessoaencontrar);
                                break;
                            }
                            else if(pessoaencontrar.getId().equals(enfermeiroid) && pessoaencontrar.getClass().getSimpleName().equals("EnfermeiroEspecialista")){
                                System.out.println("LISTA DE PACIENTES A AGUARDAR CURATIVO DO ENFERMEIRO ESPECIALISTA " + pessoaencontrar.getId() + " DE NOME " + ((EnfermeiroEspecialista) pessoaencontrar).getNome() + " :");
                                listarPacientesCurativo((Enfermeiro) pessoaencontrar);
                                break;
                            }
                            else if(pessoaencontrar.getId().equals(enfermeiroid) && !(pessoaencontrar.getClass().getSimpleName().equals("EnfermeiroEspecialista")) && !(pessoaencontrar.getClass().getSimpleName().equals("EnfermeiroAuxiliar"))){
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
    
    public void listarEnfermeiros(Medico medico)
    {
        for(EnfermeiroAuxiliar ea : medico.getAuxiliaresAcompanhados().values()){
            System.out.println(ea);
        }
        for(EnfermeiroEspecialista ee : medico.getEspecialistasAcompanhados().values()){
            System.out.println(ee);
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
    //getters e setters
    //toString
    //equals
}
