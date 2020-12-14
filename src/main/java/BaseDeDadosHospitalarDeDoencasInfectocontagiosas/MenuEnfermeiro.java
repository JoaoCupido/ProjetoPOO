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
        
    }
    
    public void listarPacientesCurativo(Hospital hospital)
    {
        
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
