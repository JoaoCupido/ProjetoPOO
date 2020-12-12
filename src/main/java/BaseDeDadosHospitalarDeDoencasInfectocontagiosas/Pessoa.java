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
public class Pessoa {
    private String id;
    private static int contarPessoas;
    
    public Pessoa(){
        id = criarID();
    }
    
    public String criarID(){
        if((this.id).equals("")) {
            contarPessoas++;
            id = "ID" + contarPessoas;
        }
        return id;
    }
    
    public String getId(){
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
}
