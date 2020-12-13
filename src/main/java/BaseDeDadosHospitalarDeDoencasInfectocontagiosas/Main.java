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
        boolean sair = false;
        while(!sair){
            int opcao;
            System.out.println("***Menu***");
            System.out.println("1) Medico");
            System.out.println("2) Enfermeiro");
            System.out.println("3) Administrador"+"\n");
            Scanner escolha = new Scanner(System.in);
            System.out.println("Digite uma opcao. Digite nenhuma das opcoes apresentadas para sair do programa: ");
            opcao = escolha.nextInt();
            switch(opcao)
            {
                case 1:
                    System.out.println("opcao1"+"\n");//implementar o menu na class medico e depois colocar aqui!!!!;
                    menuadministrador.menuOpcoes(hospital);
                    break;
                case 2:
                    System.out.println("opcao2"+"\n");//implementar o menu na class enfermeiro e depois colocar aqui!!!!;
                    break;
                case 3:
                    System.out.println("opcao3"+"\n");//implementar o menu na class administrador e depois colocar aqui!!!!;
                    break;
                default:
                    System.out.println("sair"+"\n");
                    sair = true;
                    break;
            }
        }
    }
}
