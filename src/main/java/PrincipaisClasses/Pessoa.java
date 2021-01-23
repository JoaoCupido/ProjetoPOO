/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrincipaisClasses;

/**
 *
 * @author jcupi
 */
public class Pessoa {
    //variaveis de instancia
    private String id;
    private static int contarPessoas;
    
    //construtor
    public Pessoa(){
        id = criarID();
    }
    
    //metodos
    public String criarID(){
        if(this.id == null) {
            contarPessoas++;
            id = "ID" + contarPessoas;
        }
        return id;
    }
    
    //getters e setters
    public String getId(){
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public int getContarPessoas(){
        return contarPessoas;
    }
    public void setContarPessoas(int contarPessoas){
        this.contarPessoas = contarPessoas;
    }
    
    //toString
    //equals
}
