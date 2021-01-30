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
    /**
     * Construtor de Pessoa
     */
    public Pessoa(){
        id = criarID();
    }
    
    //metodos
    /**
     * criarID: retorna um novo ID à pessoa
     * @return 
     */
    public String criarID(){
        if(this.id == null) {
            contarPessoas++;
            id = "ID" + contarPessoas;
        }
        return id;
    }
    
    //getters e setters
    /**
     * Getter da variável de instância id
     * @return 
     */
    public String getId(){
        return id;
    }
    /**
     * Setter da variável de instância id
     * @param id
     */
    public void setId(String id)
    {
        this.id=id;
    }
    /**
     * Getter da variável de instância contarPessoas
     * @return 
     */
    public int getContarPessoas(){
        return contarPessoas;
    }
    /**
     * Setter da variável de instância contarPessoas
     * @param contarPessoas 
     */
    public void setContarPessoas(int contarPessoas){
        this.contarPessoas = contarPessoas;
    }
    
    //toString
    //equals
}
