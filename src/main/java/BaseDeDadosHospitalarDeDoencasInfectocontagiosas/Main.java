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
public class Main {
    public static void main(String args[])
    {
        Hospital hospital = new Hospital();
        MenuAdministrador menuadministrador = new MenuAdministrador();
        MenuMedico menumedico = new MenuMedico();
        MenuEnfermeiro menuenfermeiro = new MenuEnfermeiro();
        while(!menuadministrador.getSair()){
            int opcao;
            System.out.println("***Menu***");
            System.out.println("1) Médico");
            System.out.println("2) Enfermeiro");
            System.out.println("3) Administrador"+"\n");
            Scanner escolha = new Scanner(System.in);
            System.out.println("Digite uma opção que esteja apresentada no Menu: ");
            opcao = escolha.nextInt();
            switch(opcao)
            {
                case 1:
                    System.out.println("\nEscolhido a opção Médico...\n");//implementar o menu na class medico e depois colocar aqui!!!!;
                    menumedico.menuOpcoesMedico(hospital);
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Enfermeiro...\n");//implementar o menu na class enfermeiro e depois colocar aqui!!!!;
                    menuenfermeiro.menuOpcoesEnfermeiro(hospital);
                    break;
                case 3:
                    System.out.println("\nEscolhido a opção Administrador...\n");//implementar o menu na class administrador e depois colocar aqui!!!!;
                    menuadministrador.menuOpcoesAdministrador(hospital);
                    break;
                default:
                    System.out.println("\nERRO! Não foi escolhido nenhuma das opções que foram apresentadas! Recomeçando...\n");
                    break;
            }
        }
    }
}
