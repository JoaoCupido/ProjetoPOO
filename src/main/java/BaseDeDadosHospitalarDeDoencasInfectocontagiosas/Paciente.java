/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDadosHospitalarDeDoencasInfectocontagiosas;

/**
 *
 * @author jcupi
 */
public class Paciente {
    private int anonascimento;
    private String id;
    
    private static int contarPacientes;
    
    //ConstrutorD
    public Paciente(int anonascimento){
        this.anonascimento = anonascimento;
        if((this.id).equals("")) {
            contarPacientes++;
            id = "ID" + contarPacientes;
        }
    }
}
