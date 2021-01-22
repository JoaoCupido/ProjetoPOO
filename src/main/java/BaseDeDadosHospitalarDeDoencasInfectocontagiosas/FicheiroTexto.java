/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;
import java.io.BufferedReader;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


/**
 *
 * @author jcupi
 */
public class FicheiroTexto {
    //variaveis de instancia
    //construtor
    //metodos
    public void escreverFicheiroTexto(Hospital hospital) throws IOException{
        String file = "HospitalProjeto.txt";
        
        // Cria a stream & abre o ficheiro
        FileWriter outStream = new FileWriter(file);
        BufferedWriter bW = new BufferedWriter(outStream);
        PrintWriter out = new PrintWriter(bW);
        
        // Ciclo de escrita
        //:> DADOS DO HOSPITAL
        out.println("-- DADOS DO HOSPITAL --");
        out.println("Anos de carreira mínimo: " + hospital.getAnosCarreiraMinimo());
        out.println();
        
        for(Pessoa pessoa : hospital.getListaPessoas().values()){
            switch (pessoa.getClass().getSimpleName()) {
                case "Paciente":
                    out.println((Paciente) pessoa);
                    break;
                case "Medico":
                    out.println((Medico) pessoa);
                    break;
                case "EnfermeiroAuxiliar":
                    out.println((EnfermeiroAuxiliar) pessoa);
                    break;
                case "EnfermeiroChefe":
                    out.println((EnfermeiroChefe) pessoa);
                    break;
                case "EnfermeiroEspecialista":
                    out.println((EnfermeiroEspecialista) pessoa);
                    break;
                default:
                    break;
            }
        }
        
        out.println();
        
        for(Paciente paciente : hospital.getListaPacientes().values())
            out.println(paciente);
        
        out.println();
        
        out.println("-- RELATORIO -- ");
        out.println(hospital.getRelatorio());
        
        out.println();
        
        out.println("-- PEDIDOS AUXILIARES -- ");
        for(Pessoa auxiliar : hospital.getPedidos())
            out.println(auxiliar);
        
        out.close();  // fechar a stream
        System.out.println("Foi criado o ficheiro: " + file);
    }
}
