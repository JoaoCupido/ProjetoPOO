/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.util.Scanner;

/**
 *
 * @author Utilizador
 */
public class MenuMedico {
    //variaveis de instancia
    //construtor
    //metodos
    public void menuOpcoesMedico(Hospital hospital){
        int opcao;
        System.out.println("***SubMenu Médico***");
        System.out.println("1) Listar Pacientes em espera no Hospital");
        System.out.println("2) Listar Pacientes a aguardar Alta");
        System.out.println("3) Diagnóstico ao Paciente");
        System.out.println("4) Dar Alta Hospitalar");
        System.out.println("5) Requerimento de Auxiliares");
        Scanner escolha = new Scanner(System.in);
        System.out.println("Digite uma opção. Digite nenhuma das opções apresentadas para sair do SubMenu Médico: ");
        opcao = escolha.nextInt();

        switch(opcao)
            {
                case 1:
                    System.out.println("\nEscolhido a opção Listar Pacientes em espera no Hospital...\n");
                    listarPacientesEspera(hospital);
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Listar Pacientes a aguardar Alta...\n");
                    listarPacientesAlta(hospital);
                    break;
                case 3:
                    System.out.println("\nEscolhido a opção Diagnóstico ao Paciente...\n");
                    diagnosticoPaciente(hospital);
                    break;
                case 4:
                    System.out.println("\nEscolhido a opção Dar Alta Hospitalar...\n");
                    altaHospitalar(hospital);
                    break;
                case 5:
                    System.out.println("\nEscolhido a opção Requerimento de Auxiliares...\n");
                    requerimentoAuxiliares(hospital);
                    break;
                default:
                    System.out.println("\nNão foi escolhido nenhuma das opções que foram apresentadas! Voltando para Menu...\n");
                    break;
        }
    }
    /*
    Lista de Pacientes em espera!
    */
    public void listarPacientesEspera(Hospital hospital)
    {
        for(int i = 0; i < hospital.getListaPacientes().size(); i++){
            System.out.println(hospital.getListaPacientes().get(i));
        }
    }
    
    /*
    Lista de Pacientes que aguardam alta por parte do médico, apos o enfermeiro aplicar o curativo!
    */
    public void listarPacientesAlta(Hospital hospital)
    {
    }
    
    /*
    Paciente que deu entrada no hospital. Sera feito um diagnostico caso de positivo de patologia sera colocado na agenda dos enfermeiros alocados ao medico
    */
    public void diagnosticoPaciente(Hospital hospital)
    {
    }
    
    public void altaHospitalar(Hospital hospital)
    {
    }
    
    public void requerimentoAuxiliares(Hospital hospital)
    {
    }
    //getters e setters
    //toString
    //equals
}
