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
    private boolean Covid, HIV, leucocitosBaixos;
    
    private static int contarPacientes;
    
    //ConstrutorD
    public Paciente(int anonascimento){
        this.anonascimento = anonascimento;
        if((this.id).equals("")) {
            contarPacientes++;
            id = "ID" + contarPacientes;
        }
    }
    //metodos
    //getters e setters
    public int getAnoNascimento()
    {
        return anonascimento;
    }
    public void setAnoNascimento(int anonascimento)
    {
        this.anonascimento=anonascimento;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    //toString
    @Override
    public String toString()
    {
        String info;
        info = "" ;
        return info;
    }
    //equals
}
