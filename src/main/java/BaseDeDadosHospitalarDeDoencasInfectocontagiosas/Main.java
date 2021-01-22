/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.io.IOException;
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
        FicheiroTexto ficheirotexto = new FicheiroTexto();
        System.out.println("Insere os anos de carreira mínimo do hospital: ");
        Scanner scanner = new Scanner(System.in);
        hospital.setAnosCarreiraMinimo(scanner.nextInt());
        while(!menuadministrador.getSair()){
            int opcao;
            System.out.println("***Menu***");
            System.out.println("1) Médico");
            System.out.println("2) Enfermeiro");
            System.out.println("3) Administrador");
            System.out.println("4) Escrever Ficheiro de Texto"+"\n");
            System.out.println("Digite uma opção que esteja apresentada no Menu: ");
            opcao = scanner.nextInt();
            switch(opcao)
            {
                case 1:
                    System.out.println("\nEscolhido a opção Médico...\n");//implementar o menu medico;
                    menumedico.menuOpcoesMedico(hospital);
                    break;
                case 2:
                    System.out.println("\nEscolhido a opção Enfermeiro...\n");//implementar o menu enfermeiro;
                    menuenfermeiro.menuOpcoesEnfermeiro(hospital);
                    break;
                case 3:
                    System.out.println("\nEscolhido a opção Administrador...\n");//implementar o menu administrador;
                    menuadministrador.menuOpcoesAdministrador(hospital);
                    break;
                case 4:
                    System.out.println("\nEscolhido a opção Escrever Ficheiro de Texto...\n");//implementar o menu ficheirotexto;
                    try{
                        ficheirotexto.escreverFicheiroTexto(hospital);
                    }
                    catch(IOException ioe){
                        System.out.println("\nERRO! IOException!");
                        System.out.println(ioe.getMessage());
                    }
                    break;
                default:
                    System.out.println("\nERRO! Não foi escolhido nenhuma das opções que foram apresentadas! Voltando ao Menu...\n");
                    break;
            }
        }
    }
}
