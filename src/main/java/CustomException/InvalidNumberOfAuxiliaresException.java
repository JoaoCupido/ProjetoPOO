/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomException;

/**
 *
 * @author jcupi
 */
public class InvalidNumberOfAuxiliaresException extends Exception{
    /**
     * Construtor: invocar a mensagem de erro da superclasse Exception
     * @param errorMessage 
     */
    public InvalidNumberOfAuxiliaresException(String errorMessage){
        super(errorMessage);
    }
}
