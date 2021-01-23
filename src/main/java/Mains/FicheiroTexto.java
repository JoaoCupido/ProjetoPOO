/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;
import PrincipaisClasses.*;

import java.io.BufferedWriter;
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
    /**
     * Vai criar um ficheiro de texto com os dados do hospital
     * @param hospital
     * @throws IOException 
     */
    public void escreverFicheiroTexto(Hospital hospital) throws IOException{
        String file = "HospitalProjeto.txt";
        
        // Cria a stream & abre o ficheiro
        FileWriter outStream = new FileWriter(file);
        BufferedWriter bW = new BufferedWriter(outStream);
        PrintWriter out = new PrintWriter(bW);
        
        // Ciclo de escrita
        //:> DADOS DO HOSPITAL
        out.println("-*-*- DADOS DO HOSPITAL -*-*-");
        out.println("Anos de carreira mínimo: " + hospital.getAnosCarreiraMinimo());
        out.println();
        
        out.println("-- HISTÓRICO DE PESSOAS DO HOSPITAL --");
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
        
        out.println("-- LISTA DE PACIENTES EM ESPERA NO HOSPITAL --");
        for(Paciente paciente : hospital.getListaPacientes().values())
            out.println(paciente);
        
        out.println();
        
        out.println(hospital.getRelatorio());
        
        out.println();
        
        out.println("-- PEDIDOS DE AUXILIARES -- ");
        for(Pessoa auxiliar : hospital.getPedidos())
            out.println(auxiliar);
        
        out.close();  // fechar a stream
        System.out.println("Foi criado o ficheiro: " + file);
    }
}
