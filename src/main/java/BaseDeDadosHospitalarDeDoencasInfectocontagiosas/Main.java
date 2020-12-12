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
        int opcao;
        System.out.println("***Menu***"+"\n");
        System.out.println("1) Medico"+"\n");
        System.out.println("2) Enfermeiro"+"\n");
        System.out.println("3) Administrador"+"\n");
        Scanner escolha = new Scanner(System.in);
        System.out.println("Digite uma opcao: ");
        opcao = escolha.nextInt();
        switch(opcao)
        {
            case 1 -> System.out.println("opcao2"+"\n") ;//implementar o menu na class medico e depois colocar aqui!!!!;
            case 2 -> System.out.println("opcao2"+"\n");//implementar o menu na class enfermeiro e depois colocar aqui!!!!;
            case 3 -> System.out.println("opcao3"+"\n");//implementar o menu na class administrador e depois colocar aqui!!!!;
        }
        
    }
}
